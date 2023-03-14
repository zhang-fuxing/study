package com.example.networkserve1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对外接口访问限制aop类
 *
 * @author zhangfx
 * @date 2023/2/1
 */
@Aspect
@Component
public class ApiVisitControl {
	public static final Jedis JEDIS;
	
	static {
		JEDIS = new Jedis(new HostAndPort("192.168.235.111", 6379), new JedisClientConfig() {
			@Override
			public String getPassword() {
				return "kingshine12345";
			}
			
			@Override
			public int getDatabase() {
				return 9;
			}
		});
	}
	
	/**
	 * controller层接口的限流切入点，所有在cn.com.kingshine.geologic.controller包下的类中的所有方法
	 */
	@Pointcut("execution(* com.example.networkserve1.Networkserve1Application.get2(..))")
	public void apiCut() {
	}
	
	DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	
	private final ReentrantLock lock = new ReentrantLock();
	
	@Around("apiCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Class<?> clazz = signature.getDeclaringType();
		// 获取方法上的api call注解
		ApiCall mApiCall = signature.getMethod().getAnnotation(ApiCall.class);
		// 获取类上面的api call注解
		ApiCall cApiCall = clazz.getAnnotation(ApiCall.class);
		if (mApiCall == null && cApiCall == null) {
			// 如果方法上和类上都没有 ApiCall 注解，那么不做限流，不对接口做增强
			return joinPoint.proceed();
		}
		
		long limiting;
		long time;
		TimeUnit unit;
		if (mApiCall != null) {
			// 方法上有注解，优先使用方法上的注解，忽略类上的注解
			boolean disable = mApiCall.disable();
			// 如果方法上的限流注解被禁用，那么直接执行方法，不做限制，让注解作用失效
			if (disable) return joinPoint.proceed();
			limiting = mApiCall.limiting();
			unit = mApiCall.unit();
			time = getTime(mApiCall.time(), unit);
		} else {
			// 方法上没有注解，但是类上有注解，对所有没有使用ApiCall的接口进行限流控制
			// 如果类上的限流注解被禁用，那么直接执行方法，不做限制，让注解作用失效
			if (cApiCall.disable()) return joinPoint.proceed();
			limiting = cApiCall.limiting();
			unit = cApiCall.unit();
			time = getTime(cApiCall.time(), unit);
		}
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		RequestContextHolder.setRequestAttributes(attributes, true);
		if (attributes == null) throw new RuntimeException("无法获取应用上下文");
		HttpServletRequest request = attributes.getRequest();
		
		lock.lock();
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(pattern);
		String appKey = request.getHeader("appKey");
		String secret = request.getHeader("secret");
		String key = appKey + ":" + secret;
		if (!JEDIS.exists(key)) {
			// 当前单位时间内第一次访问接口，redis内无数据，添加数据
			JEDIS.hsetnx(key, "count", "1");
			JEDIS.hsetnx(key, "date", now.plusSeconds(time).format(pattern));
			JEDIS.expire(key, time);
			lock.unlock();
			return joinPoint.proceed();
		}
		String redisCount = JEDIS.hget(key, "count");
		String redisDate = JEDIS.hget(key, "date");
		Long ttl = JEDIS.ttl(key);
		
		if (Long.parseLong(date) < Long.parseLong(redisDate) && Long.parseLong(redisCount) >= limiting) {
			lock.unlock();
			throw new RuntimeException("为防止恶意请求，请" + ttl + "秒后在试");
		}
		JEDIS.hincrBy(key, "count", 1);
		
		lock.unlock();
		return joinPoint.proceed();
	}
	
	public long sub(@NonNull String str1, @NonNull String str2) {
		long a = Long.parseLong(str1);
		long b = Long.parseLong(str2);
		return a - b;
	}
	
	private long getTime(long time, TimeUnit unit) {
		return unit.toSeconds(time);
	}
	
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "localhost";
		}
		return ip;
	}
}
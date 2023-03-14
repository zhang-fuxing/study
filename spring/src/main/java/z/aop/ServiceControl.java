package z.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import z.anno.ApiCall;

/**
 * @author zhangfx
 * @date 2023/2/1
 */
@Aspect
@Component
public class ServiceControl {
	
//	@Pointcut("@annotation(z.anno.ApiCall)")
//	public void pointCut(){}
	
	@Pointcut("execution(* z.control.*.*(..))")
	public void pointCut(){}
	
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		ApiCall apiCall = signature.getMethod().getAnnotation(ApiCall.class);
		System.out.println("检查方法上是否有注解ApiCall:\t" + (null == apiCall));
		Class<?> clazz = signature.getDeclaringType();
		ApiCall api1 = clazz.getAnnotation(ApiCall.class);
		System.out.println("检查类上是否有注解ApiCall:\t" + (null == api1));
		Object proceed = point.proceed();
		return proceed;
	}
}

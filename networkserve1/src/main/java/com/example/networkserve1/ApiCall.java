package com.example.networkserve1;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 接口限流访问控制
 *
 * @author zhangfx
 * @date 2023/2/1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ApiCall {
	/**
	 * 请求限制的次数，即单位时间内可以访问多少次；比如设置为 100
	 * 那么表时在unitTime 的时间内只能访问接口100次
	 * 默认-1，不做限制
	 * @return 限制的次数
	 */
	long limiting() default -1;
	
	/**
	 * 接口限流的单位时间，默认1分钟，表示1分钟可以访问接口 limiting 次
	 *
	 * @return 时间长度
	 */
	long time() default 60;
	
	/**
	 * 时间单位，默认是秒
	 * @return 时间单位
	 */
	TimeUnit unit() default TimeUnit.SECONDS;
	
	/**
	 * 表示是否禁用对当前接口的限流，设置为true后，不再对当前接口进行限流，即当前注解不生效
	 * @return true表示开启禁用，false表示关闭禁用
	 */
	boolean disable() default false;
}

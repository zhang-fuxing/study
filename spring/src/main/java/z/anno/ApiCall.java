package z.anno;

import java.lang.annotation.*;

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
	 * 限制接口访问的单位时间，默认为1分钟
	 * @return 时间毫秒数
	 */
	long unitTime() default 1000*60;
	
	/**
	 * 表示是否禁用对当前接口的限流，设置为true后，不再对当前接口进行限流，即当前注解不生效
	 * @return true表示开启禁用，false表示关闭禁用
	 */
	boolean disable() default false;
}

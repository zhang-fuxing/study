package z.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhangfx
 * @date 2023/1/31
 */

@Aspect
@Order(9999)
@Component
public class TypeAdvice {
//	@Pointcut("execution(* z.intef.*.*(..))")
//	public void cut() {}
//
//
//	@Around("cut()")
//	public Object around(ProceedingJoinPoint point) throws Throwable {
//		System.out.println("开始执行"+ point.getSignature().getName());
//		Object proceed = point.proceed();
//		System.out.println(point.getSignature().getName()+"执行完成");
//		return proceed;
//	}
	
	

	
}

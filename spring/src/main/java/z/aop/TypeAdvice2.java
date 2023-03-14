package z.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhangfx
 * @date 2023/1/31
 */

@Aspect
@Order(1)
@Component
public class TypeAdvice2 {
//	@Pointcut("execution(* z.intef.*.*(..))")
//	public void cut2() {}
//
//	@Around("cut2()")
//	public Object around2(ProceedingJoinPoint point) throws Throwable {
//		System.out.println("开始执行"+ point.getSignature().getName()+",在切点2进行增强");
//		Object proceed = point.proceed();
//		System.out.println(point.getSignature().getName()+"在切点2执行完成");
//		return proceed;
//	}
	
	
	

	
}

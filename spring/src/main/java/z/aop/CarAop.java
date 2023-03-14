package z.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhangfx
 * @date 2023/2/1
 */
@Aspect
@Component
public class CarAop {
	
	@Pointcut("execution(* z.intef.impl.CarFun.carRun())")
	void cut(){}
	
	@Around("cut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("......");
		point.proceed();
		System.out.println("-------");
		return null;
	}
	
}

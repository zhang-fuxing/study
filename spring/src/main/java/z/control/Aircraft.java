package z.control;

import org.springframework.stereotype.Component;
import z.anno.ApiCall;

/**
 * @author zhangfx
 * @date 2023/1/31
 */
@Component
public class Aircraft{
	@ApiCall(limiting = 30000, unitTime = 1000*60*60)
	public void fly() {
		System.out.println("起飞~~~");
	}
}

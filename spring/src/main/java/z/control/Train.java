package z.control;

import org.springframework.stereotype.Component;
import z.anno.ApiCall;

/**
 * @author zhangfx
 * @date 2023/1/31
 */
@Component
@ApiCall(limiting = 30000, unitTime = 1000*60*60)
public class Train{
	public void run() {
		System.out.println("呜呜呜呜。。。");
	}
}

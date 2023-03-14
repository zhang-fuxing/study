package z.intef.impl;

import org.springframework.stereotype.Service;
import z.anno.ApiCall;
import z.intef.RunType;

/**
 * @author zhangfx
 * @date 2023/1/31
 */
@Service
@ApiCall(limiting = 30000, unitTime = 1000*60*60)
public class KaImpl implements RunType {
	@Override
	public void run() {
		System.out.println("Ka run。。。");
	}
}

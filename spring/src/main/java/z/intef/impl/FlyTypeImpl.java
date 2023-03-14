package z.intef.impl;

import org.springframework.stereotype.Service;
import z.anno.ApiCall;
import z.intef.FlyType;

/**
 * @author zhangfx
 * @date 2023/1/31
 */
@Service
public class FlyTypeImpl implements FlyType {
	@Override
	@ApiCall(limiting = 30000, unitTime = 1000*60*60)
	public void fly() {
		System.out.println("wuwuwu~~~");
	}
}

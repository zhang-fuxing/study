package z.intef.impl;

import org.springframework.stereotype.Service;
import z.intef.RunType;

/**
 * @author zhangfx
 * @date 2023/1/31
 */
@Service
public class RunTypeImpl implements RunType {
	@Override
	public void run() {
		System.out.println("夏姬8跑");
	}
}

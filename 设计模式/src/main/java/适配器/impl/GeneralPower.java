package 适配器.impl;

import 适配器.fun.Power;

/**
 * 标准电压，能量
 * @author zhangfx
 * @date 2023/2/6
 */
public class GeneralPower implements Power {
	@Override
	public int get() {
		return 220;
	}
}

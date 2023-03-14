package 适配器.adapter;

import 适配器.fun.Power;

/**
 * 将220v的电压转换为手机需要的5v
 * @author zhangfx
 * @date 2023/2/6
 */
public class PhoneAdapter implements Power {
	
	public Power generalPower;
	
	public PhoneAdapter(Power generalPower) {
		this.generalPower = generalPower;
	}
	
	@Override
	public int get() {
		int power = generalPower.get();
		return power/44;
	}
}

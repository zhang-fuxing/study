package 适配器.product;

import 适配器.fun.Power;

/**
 * 产品、手机
 * @author zhangfx
 * @date 2023/2/3
 */
public class Phone {
	Power power;
	
	public Phone(Power power) {
		this.power = power;
		System.out.println("当前使用电压：" + power.get() + "V。");
	}
	
	public void setPower(Power power) {
		this.power = power;
	}
	
	public Power getPower() {
		return power;
	}
}

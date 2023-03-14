package 适配器;


import util.DateUtil;
import 适配器.adapter.PhoneAdapter;
import 适配器.impl.GeneralPower;
import 适配器.product.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 适配器模式
 * 通用能力电压Power的实现是220v，供大多数家电使用。
 * 手机需要使用电能，但是只需要5v的，不能改变原来的电力供应
 * 添加适配器，将220转换到5
 *
 * @author zhangfx
 * @date 2023/2/6
 */
public class Main {
	public static void main(String[] args) {
		new Phone(new GeneralPower());
		new Phone(new PhoneAdapter(new GeneralPower()));
		long date = 1675668970328L;
		Date time = new Date(date);
		LocalDateTime localDateTime = DateUtil.dateToLocalDateTime(time);
		localDateTime = localDateTime.plusDays(1);
		int second = localDateTime.getSecond();
		System.out.println(second);
		if (second != 0) {
			localDateTime = localDateTime.plusSeconds(60-second);
		}
		System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss SSSS")));
		long end = DateUtil.localDateTimeToDate(localDateTime).getTime();
		
		System.out.println(end);
	}
}

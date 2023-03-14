package com.zfx.util.encrypt;

import com.zfx.util.date.DateUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhangfx
 * @date 2023/2/22
 */
public class Test1 {
	
	public static void main(String[] args) {
		String timestamp = String.valueOf(System.currentTimeMillis());
		LocalDateTime localDateTime = DateUtils.dateToLocalDateTime(new Date(Long.parseLong(timestamp)));
		LocalDateTime lt1 = localDateTime.plusMinutes(15);
		long time = DateUtils.localDateTimeToDate(lt1).getTime();
		System.out.println(time - Long.parseLong(timestamp));
		
		System.out.println(1000*60*15);
	}
}

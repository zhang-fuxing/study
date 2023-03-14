package com.zfx.util;

/**
 * String 格式化
 * <p>
 * 占位符说明
 * <p>
 * %s  字符串 String
 * <p>
 * %c  字符类型 char
 * <p>
 * %b  布尔类型 boolean
 * <p>
 * %d  整数类型 10进制
 * <p>
 * %x  整数 16进制类型
 * <p>
 * %o  整数8进制类型
 * <p>
 * %f  浮点类型
 * <p>
 * %a  16进制浮点类型
 * <p>
 * %e  指数类型
 * <p>
 * %g  通用浮点类型
 * <p>
 * %h  散列码
 * <p>
 * %%  百分比类型
 * <p>
 * %tx 日期与时间类型(x代表不同的日期与时间转换符)
 * <p>
 * 0011 0110
 * <p>
 * 1111 0000
 * <p>
 * 0011 0000
 *
 * @author zhangfx
 * @date 2023/3/3
 */
public class StringFormat {
	public static void main(String[] args) throws Exception {
		System.out.printf("%b", (Object) null);
	}
}
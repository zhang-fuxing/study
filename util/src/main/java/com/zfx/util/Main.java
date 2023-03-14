package com.zfx.util;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangfx
 * @date 2023/2/22
 */
public class Main {
	public static void main(String[] args) {
		String str = """
				{
								
				    "AccessKey":1631101255391727616,
								
				    "secret":"V222ddM7Yxf06cNUU6DpKREH2gimB5Yk",
								
				    "generateDateTime":1677719818338,
								
				    "expireDateTime":1680311818338
								
				}""";
		
		JSONObject obj = JSONUtil.parseObj(str);
		String accessKey = obj.getStr("AccessKey");
		String secret = obj.getStr("secret");
		long timestamp = System.currentTimeMillis();
		
		String signStr = accessKey + timestamp + secret;
		String sign = MD5.create().digestHex(signStr, "UTF-8").toUpperCase();
		System.out.println(sign);
		System.out.println(timestamp);
	}
	
	public static boolean and(boolean... tar) {
		if (tar == null || tar.length == 0) return false;
		boolean result = true;
		for (boolean var : tar) {
			result = (result && var);
		}
		return result;
	}
	
	public static boolean fieldCheck(String str) {
		String pattern = "^((?![\\'\\/\\*\\-]).)*$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		return m.matches();
	}
}

package com.zfx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangfx
 * @date 2023/3/2
 */
public class Test1 {
	
	public static void main(String[] args) {
		Date date = new Date(1677722206275l);
		System.out.println(new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(date));
	}
	
	public static void set(ExternalAuth auth) {
		auth.setAccessKey("1631101255391727616").setTimestamp(String.valueOf(System.currentTimeMillis())).setSign("82D74322B25234F50C76EAD18E551A94");
	}
	
	static class ExternalAuth {
		String AccessKey;
		String Timestamp;
		String Sign;
		
		public ExternalAuth() {
		}
		
		public ExternalAuth(String accessKey, String timestamp, String sign) {
			AccessKey = accessKey;
			Timestamp = timestamp;
			Sign = sign;
		}
		
		@Override
		public String toString() {
			return "ExternalAuth{" +
					"AccessKey='" + AccessKey + '\'' +
					", Timestamp='" + Timestamp + '\'' +
					", Sign='" + Sign + '\'' +
					'}';
		}
		
		public String getAccessKey() {
			return AccessKey;
		}
		
		public ExternalAuth setAccessKey(String accessKey) {
			AccessKey = accessKey;
			return this;
		}
		
		public String getTimestamp() {
			return Timestamp;
		}
		
		public ExternalAuth setTimestamp(String timestamp) {
			Timestamp = timestamp;
			return this;
		}
		
		public String getSign() {
			return Sign;
		}
		
		public ExternalAuth setSign(String sign) {
			Sign = sign;
			return this;
		}
	}
}

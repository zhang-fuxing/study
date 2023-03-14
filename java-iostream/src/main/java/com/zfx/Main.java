package com.zfx;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(md5("kkkkkkkaaaaa", StandardCharsets.UTF_8));
	}
	
	static final char[] s = "0123456789abcdef".toCharArray();
	static final char[] d = "0123456789ABCDEF".toCharArray();
	
	public static String md5(String str, Charset charset, boolean isUpperCase) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] bytes = digest.digest(str.getBytes(charset));
		char[] chars = encode(bytes, isUpperCase);
		return String.valueOf(chars);
	}
	public static String md5(String str, Charset charset) throws NoSuchAlgorithmException {
		return md5(str, charset, true);
	}
	
	private static char[] encode(byte[] bytes, boolean isUpperCase) {
		int len = bytes.length;
		final char[] out = new char[len << 1];
		char[] encode = getEncode(isUpperCase);
		for (int i = 0, j = 0; i < len; i++) {
			out[j++] = encode[(0xF0 & bytes[i]) >>> 4];
			out[j++] = encode[0x0f & bytes[i]];
		}
		return out;
	}
	
	private static char[] getEncode(boolean isUpperCase) {
		return isUpperCase ? d : s;
	}
}

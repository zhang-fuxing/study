package com.zfx.util.encrypt;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.AlgorithmUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import sun.misc.Unsafe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

/**
 * @author zhangfx
 * @date 2023/2/14
 */
public class Main {
	public static void main(String[] args) throws Exception {
		/*HashMap<String, Object> map = new HashMap<>();
		map.put("name","zzffxx");
		map.put("sex", 1);
		map.put("age", "25");
		map.put("date", LocalDateTime.now());
		JWTSigner hs256 = JWTSignerUtil.createSigner(AlgorithmUtil.getAlgorithm("HS256"), "kfk".getBytes());
		String token = JWTUtil.createToken(map, hs256);
		System.out.println(token);*/
		JWTSigner hs256 = JWTSignerUtil.createSigner(AlgorithmUtil.getAlgorithm("HS256"), "kfk".getBytes());
		HashMap<String, Object> map = new HashMap<>();
		map.put("name","zzffxx");
		map.put("sex", 1);
		map.put("age", "25");
		map.put("date", LocalDateTime.now());
		String t = JWTUtil.createToken(map, hs256);
		String sign = JWT.create()
				.setSigner(hs256)
				.setIssuedAt(new Date())
				.addPayloads(map).sign();
		System.out.println(sign);
		
		String tokenn = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzY5NDM0NTYsImRhdGUiOjE2NzY5NDM0NTYsInNleCI6MSwibmFtZSI6Inp6ZmZ4eCIsImFnZSI6IjI1In0.q2Kx7FWuoWy3ddX0VDea1oIbFL-llZKD6ANfXa6w4j4";
		
		JWTValidator.of(tokenn).validateAlgorithm(hs256).validateDate(new Date());
		
		String s = JSONUtil.createObj()
				.set("userName", "zhangfx")
				.set("userId", IdUtil.getSnowflake().nextId())
				.set("date", LocalDateTime.now())
				.toString();
		
		
		
	}
	
	static enum Type {
		DATA,DOC;
	}
	
	private static Unsafe reflectGetUnsafe() {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			return (Unsafe) field.get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	@TestA
	static class TestB {
		private static final String name = "zzf";
		
		public String getName() {
			return name;
		}
	}
	
	static class TestC {
		private String name;
		public TestC(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface TestA {
		String xyz() default "zfx";
	}
}

package com.example.networkserve2;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.MD5;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Networkserve2Application.class)
@RunWith(SpringRunner.class)
class Networkserve2ApplicationTests {
	String pass_source = "qwertyuiopasdfghjklzxcvbnm0123456789.[]QWERTYUIOPASDFGHJKLZXCVBNM!#=+-";
	
	
	@Test
	void contextLoads() {
		long accessId = IdUtil.getSnowflakeNextId();
		long timestamp = System.currentTimeMillis();
		String password = generatorPassword(32);
		String nanoId = IdUtil.nanoId();
		
		System.out.println(accessId);
		System.out.println(timestamp);
		System.out.println(password);
		System.out.println(nanoId);
		
		String sign = MD5.create().digestHex(timestamp + nanoId + password, "UTF-8");
		System.out.println(sign.toUpperCase());
		
		
		
	}
	
	
	public String generatorPassword(final int passLen) {
		Random random = new Random(System.currentTimeMillis());
		StringBuilder password = new StringBuilder();
		int len = passLen == 0 ? 16 : passLen;
		for (int i = 0; i < len; i++) {
			int index = random.nextInt(pass_source.length());
			password.append(pass_source.charAt(index));
		}
		return password.toString();
	}
	
	public String generatorPassword() {
		return generatorPassword(0);
	}
}

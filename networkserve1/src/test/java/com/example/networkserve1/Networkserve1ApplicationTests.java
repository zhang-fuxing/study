package com.example.networkserve1;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Networkserve1ApplicationTests {
	
	@Autowired
	private StringEncryptor encryptor;
	
	@Value("${kingshine.pwd}")
	private String pwd;
	
	@Test
	void contextLoads() {
//		String a = encryptor.encrypt("kingshine12345");
//		System.out.println(a);
		System.out.println(pwd);
	}
	
}

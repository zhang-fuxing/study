package com.example.networkserve1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangfx
 * @date 2023/2/21
 */
@Configuration
public class AppConfig {
	
	@Bean
	public Map<String,Object> user() {
		
		return new HashMap<>(1);
	}
}

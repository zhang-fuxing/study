package com.zfx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.zfx")
public class JavaConfig {
    String name;
	
	public String getName() {
		this.name="zfx";
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

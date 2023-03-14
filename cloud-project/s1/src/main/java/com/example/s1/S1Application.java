package com.example.s1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class S1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(S1Application.class, args);
	}
	
	@Value("${config.info}")
	private String info;
	
	@Value("${config.yyz}")
	private String yyz;
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public String getInfo() {
		return "service1:-port=" + port +info + " : " + yyz;
	}
}

package com.example;

import com.example.http.S1Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RefreshScope
@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class S2Application {
	public static void main(String[] args) {
		SpringApplication.run(S2Application.class, args);
	}
	
	@Resource
	RestTemplate template;
	
	@Resource
	S1Service s1;
	
	@Value("${config.info}")
	private String info;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/info")
	public String get() {
		return "port:" + port + "\n" +
				"service1-data=" + s1.getInfo() + " | \n" +
				"service2-data=" + info;
	}
}

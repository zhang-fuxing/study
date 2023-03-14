package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangfx
 * @date 2023/1/5
 */

@RestController
@SpringBootApplication
public class MyGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyGatewayApplication.class, args);
	}
}

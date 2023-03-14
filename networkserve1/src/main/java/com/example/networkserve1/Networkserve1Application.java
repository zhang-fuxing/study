package com.example.networkserve1;

import cn.hutool.core.lang.Dict;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


@RestController
@SpringBootApplication
public class Networkserve1Application {
	static int count = 0;
	public static void main(String[] args) {
		SpringApplication.run(Networkserve1Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	@GetMapping("/net1/{param}")
	public <T> T get1(@PathVariable(required = false) String param, HttpServletRequest request) {
		return (T) new ResponseEntity("请求错误", HttpStatus.BAD_REQUEST);
		/*request.getParameterMap().forEach((k,v) -> System.out.println(k+":"+ Arrays.toString(v)+ ":" + Arrays.toString(v).contains(",") + ":" + v.length));
		if (param != null && param.contains(":")) {
			String[] ps = param.split(":");
			return (T) (Arrays.stream(ps).map(item -> item+":net1").toList());
		}
		return (T) ("server1:-" + param + "\n" + request);*/
	}
	
	@ApiCall(limiting = 100, time = 120,unit = TimeUnit.MINUTES)
	@RequestMapping("/net1/p")
	public Object get2(/*@RequestBody Params params*/) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		RequestContextHolder.setRequestAttributes(requestAttributes, true);
		HttpServletRequest request = requestAttributes.getRequest();
		String appKey = request.getHeader("appKey");
		String secret = request.getHeader("secret");
//		System.out.println("appKey:" + appKey + "\nsecret:" + secret);
		getUri();
//		System.out.println(params);
//		return new ResponseEntity("请求错误", HttpStatus.BAD_REQUEST);
		Dict set = Dict.create().set("appKey", appKey).set("secret", secret);
		return set;
	}
	
	public void getUri() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		RequestContextHolder.setRequestAttributes(requestAttributes, true);
		HttpServletRequest request = requestAttributes.getRequest();
		String appKey = request.getHeader("appKey");
		String secret = request.getHeader("secret");
		String uri = request.getRequestURI();
		System.out.println(uri);
	}
	
	static class Params {
		private String appCode;
		private String secret;
		private String code;
		
		public String getAppCode() {
			return appCode;
		}
		
		public void setAppCode(String appCode) {
			this.appCode = appCode;
		}
		
		public String getSecret() {
			return secret;
		}
		
		public void setSecret(String secret) {
			this.secret = secret;
		}
		
		public String getCode() {
			return code;
		}
		
		public void setCode(String code) {
			this.code = code;
		}
		
		@Override
		public String toString() {
			return "Params{" +
					"appCode='" + appCode + '\'' +
					", secret='" + secret + '\'' +
					", code='" + code + '\'' +
					'}';
		}
	}
}

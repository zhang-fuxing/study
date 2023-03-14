package com.example.networkserve1;

import cn.hutool.core.lang.Dict;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangfx
 * @date 2023/2/2
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
	
	private ObjectMapper objectMapper;
	
	@Autowired
	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	@ExceptionHandler(value = {RuntimeException.class})
	public <T> ResponseEntity<T> sysExpHandler(Exception e) {
		return new ResponseEntity<T>((T) e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}
	
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
								  Class<? extends HttpMessageConverter<?>> selectedConverterType,
								  ServerHttpRequest request, ServerHttpResponse response) {
		return Dict.create()
				.set("code", 200)
				.set("data", body)
				.set("time", LocalDateTime
						.now()
						.format(DateTimeFormatter
								.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}

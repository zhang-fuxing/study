package com.example.networkserve2.controller;

import cn.hutool.json.JSONUtil;
import com.example.networkserve2.Params;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangfx
 * @date 2023/2/13
 */
@RestController
public class ApiController {
	
	@PostMapping("/oauth/token")
	public String getToken(@RequestBody Params params, HttpServletRequest request, HttpServletResponse response) {
		String code = params.getCode();
		String appCode = params.getAppCode();
		String secret = params.getSecret();
		return JSONUtil.createObj().set("token","12333").toJSONString(4);
	}
	
	@PostMapping("/oauth/userinfo")
	public String userInfo(@RequestBody Params params,HttpServletRequest request, HttpServletResponse response) {
		String code = params.getCode();
		String appCode = params.getAppCode();
		String secret = params.getSecret();
		return JSONUtil.createObj()
				.set("result", JSONUtil.createObj()
						.set("userName","test133")
						.set("accountName", "test133"))
				.toJSONString(4);
	}
	
	@PostMapping("/user/getUserByCode")
	public String getUser(@RequestBody Params params,HttpServletRequest request, HttpServletResponse response) {
		String code = params.getCode();
		String appCode = params.getAppCode();
		String secret = params.getSecret();
		return JSONUtil.createObj()
				.set("user",JSONUtil.createObj().set("displayName", "test133")).toJSONString(4);
	}
	
	@GetMapping("/file")
	public String test12(@RequestParam(value = "file", required = false) String file) {
		return file;
	}
}

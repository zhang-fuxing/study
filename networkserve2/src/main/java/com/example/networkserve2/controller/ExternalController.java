package com.example.networkserve2.controller;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangfx
 * @date 2023/3/2
 */
@RestController
public class ExternalController {
	
	@RequestMapping("/projects")
	public String getProjectList() {
		String time = String.valueOf(System.currentTimeMillis());
		String key = "1631101255391727616";
		String secret = "V222ddM7Yxf06cNUU6DpKREH2gimB5Yk";
		Map<String, String> map = Map.of(
				"accessKey", key,
				"timestamp", time,
				"sign", MD5.create().digestHex(key + time + secret, "UTF-8").toUpperCase()
		);
		HttpResponse httpResponse = HttpRequest.get("http://localhost:8082/api/seismic/projectStatInfo?seisProjectId=33090")
				.addHeaders(map)
				.execute();
		return JSONUtil.parseObj(httpResponse.body()).toJSONString(4);
	}
}

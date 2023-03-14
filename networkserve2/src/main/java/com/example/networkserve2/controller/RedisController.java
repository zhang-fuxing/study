package com.example.networkserve2.controller;

import cn.hutool.core.convert.Convert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author zhangfx
 * @date 2023/2/27
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Resource
	private Jedis jedis;
	
	@Resource
	private JedisPool redisPool;
	
	@RequestMapping("/select/{dbno}")
	public String selectDB(@PathVariable(name = "dbno") int dbno, HttpSession session) {
		if (dbno != -1) {
			session.setAttribute("rdb", dbno);
		}
		Jedis redisConn =  redisPool.getResource();
		return redisConn.select(dbno);
	}
	
	@RequestMapping("/set/{key}/{data}")
	public String set(@PathVariable String key, @PathVariable String data, HttpSession session) {
		Jedis resource = redisPool.getResource();
		Integer rdb = Convert.toInt(session.getAttribute("rdb"), -1);
		if (rdb != -1) {
			resource.select(rdb);
		}
		String set = resource.set(key, data);
		resource.close();
		return set;
	}
	
	@RequestMapping("/get/{key}")
	public String get(@PathVariable String key,HttpSession session) {
		Integer rdb = Convert.toInt(session.getAttribute("rdb"), -1);
		Jedis jedis = redisPool.getResource();
		if (rdb != -1) {
			jedis.select(rdb);
		}
		String value = jedis.get(key);
		jedis.close();
		return value;
	}
	
}

package com.b.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author zfx
 * @date 2022-07-23 9:43
 */
@Configuration
public class RedisConfig {

    @Bean
    @Resource
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory) {
        var template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        FastJsonRedisSerializer<Object> fast = new FastJsonRedisSerializer<>(Object.class);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(fast);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(fast);
        template.afterPropertiesSet();
        return template;
    }
}

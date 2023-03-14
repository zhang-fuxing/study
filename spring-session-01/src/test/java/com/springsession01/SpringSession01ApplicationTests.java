package com.springsession01;

import com.springsession01.util.Redis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class SpringSession01ApplicationTests {
    @Autowired
    Redis redis;
    @Test
    void contextLoads() {
        Map<String, Object> map = redis.getMap("spring:session:sessions:fd148397-66b8-44d2-8fbb-ca23c49b3f65");
        System.out.println(map);
    }

}

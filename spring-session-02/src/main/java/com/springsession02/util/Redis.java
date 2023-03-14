package com.springsession02.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zfx
 * @date 2022-07-23 9:50
 */
@SuppressWarnings("all")
@Component
public class Redis {
    @Autowired
    private RedisTemplate redisTemplate;

    public <T> void setObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> void setObject(final String key, final T value, final int timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    public boolean expire(final String key, final int timeout) {
        return expire(key,timeout,TimeUnit.SECONDS);
    }

    public boolean expire(final String key, final int timeout, final TimeUnit timeUnit) {
        return expire(key,timeout,timeUnit);
    }

    public <T> T getObject(final String key) {
        ValueOperations<String,T> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    public boolean deleteObject(final String key) {
        return redisTemplate.delete(key);
    }

    public long deleteObject(final Collection collection) {
        return redisTemplate.delete(collection);
    }

    public <T> long setList(final String key, final List<T> list) {
        Long aLong = redisTemplate.opsForList().rightPushAll(key, list);
        return aLong == null ? 0 : aLong;
    }

    public <T> List<T> getList(final String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }

    public <T> BoundSetOperations<String,T> setSet(final String key, final Set<T> set) {
        BoundSetOperations<String,T> setOps = redisTemplate.boundSetOps(key);
        set.forEach(item -> setOps.add(item));
        return setOps;
    }

    public <T> Set<T> getSet(final String key) {
        return redisTemplate.opsForSet().members(key);
    }

    public <T> void setMap(final String key, final Map<String, T> map) {
        Optional.ofNullable(map).ifPresent(m -> redisTemplate.opsForHash().putAll(key,m));
    }

    public <T> Map<String,T> getMap(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public <T> void setMapValue(final String key, final String hashKey, final T value) {
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    public <T> T getMapValue(final String key, final String hk) {
        HashOperations<String,String,T> ops = redisTemplate.opsForHash();
        return ops.get(key,hk);
    }

    public void deleteMapValue(final String k, final String hk) {
        redisTemplate.opsForHash().delete(k,hk);
    }

    public <T> List<T> getMulitMapValue(final String k, final Collection hks) {
        return redisTemplate.opsForHash().multiGet(k,hks);
    }

    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }
}

package com.panda.common.redis.service;

import com.google.gson.Gson;
import com.panda.common.utils.GsonListParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 缓存管理
 * 相当于使用redis-cli操作redis
 * @author w
 * @date 2020-06-29
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private Gson gson;

    /**
     * 设置缓存
     * @param key Key
     * @param value VALUE
     */
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 设置缓存
     * @param key Key
     * @param value VALUE
     * @param expireTime 有效期 默认单位毫秒
     */
    public void set(String key,Object value, long expireTime){
        redisTemplate.opsForValue().set(key,value,expireTime);
    }

    /**
     * 设置缓存 List
     * @param key key
     * @param list list
     */
    public void setList(String key, List list){
        redisTemplate.opsForValue().set(key, gson.toJson(list));
    }

    /**
     * 设置缓存 List
     * @param key key
     * @param list list
     * @param expireTime 有效期 默认单位毫秒
     */
    public void setList(String key, List list, long expireTime){
        redisTemplate.opsForValue().set(key, gson.toJson(list), expireTime);
    }

    /**
     * 获取缓存数据
     * @param key KEY
     */
    public <T> T get(String key){
        return (T)redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取缓存数据
     * @param key KEY
     */
    public String getString(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    public Integer getInteger(String key){
        return (Integer) redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取数据并转换成List对象
     * @param key key
     * @param itemClass 子对象
     * @return List
     */
    public <T> List<T> getList(String key, Class itemClass){
        return gson.fromJson(getString(key),new GsonListParameterizedType(itemClass));
    }
}

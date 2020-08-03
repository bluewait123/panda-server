package com.panda.common.redis.service;

import com.google.gson.Gson;
import com.panda.common.utils.GsonListParameterizedType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * 使用Jedis管理缓存
 * @author w
 * @date 2020-06-29
 */
@Slf4j
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private Gson gson;

    /**
     * 设置字符串缓存
     * @param key KEY
     * @param value 字符串
     */
    public void set(String key,String value){
        try(Jedis jedis = jedisPool.getResource()){
            log.debug("set key --> {} : value:{}", key, value);
            jedis.set(key,value);
        }
    }

    /**
     * 获取缓存字符串数据
     * @param key KEY
     * @return String
     */
    public String get(String key){
        try(Jedis jedis = jedisPool.getResource()){
            log.debug("get key --> {}", key);
            return jedis.get(key);
        }
    }

    /**
     * 缓存对象
     * @param key KEY
     * @param obj 对象
     */
    public void putObject(String key, Object obj) {
        putObject(key, obj, null);
    }

    /**
     * 缓存对象
     * @param key KEY
     * @param obj 对象
     * @param timeout 缓存有效期
     */
    public void putObject(String key, Object obj, Integer timeout) {
        try(Jedis jedis = jedisPool.getResource()){
            String json = gson.toJson(obj);
            log.debug("putObject --> key:{} , obj:{} ,timeout:{}", key, json, timeout);
            jedis.set(key, json);
            if (timeout != null) {
                jedis.expire(key, timeout);
            }
        }
    }

    /**
     * 获取缓存对象
     * @param key KEY
     * @param targetClass JAVA BEAN CLASS
     * @return T
     */
    public <T>T getObject(String key, Class<T> targetClass) {
        T obj;
        try(Jedis jedis = jedisPool.getResource()){
            String json = jedis.get(key);
            if (null == json || "".equals(json)) {
                return null;
            }

            obj = gson.fromJson(json,targetClass);
        }
        return obj;
    }

    /**
     * 获取数据并转换成List对象
     * @param key key
     * @param itemClass 子对象
     * @return List
     */
    public <T> List<T> getList(String key, Class itemClass){
        try(Jedis jedis = jedisPool.getResource()){
            String json = jedis.get(key);
            if (null == json || "".equals(json)) {
                return null;
            }
            return gson.fromJson(json,new GsonListParameterizedType(itemClass));
        }
    }

    /**
     * 删除缓存
     * @param key KEY
     */
    public void delete(String key){
        try(Jedis jedis = jedisPool.getResource()){
            if(jedis.exists(key)){
                jedis.del(key);
            }
        }
    }

    /**
     * 检查KEY是否存在
     * @param key KEY
     */
    public Boolean exists(String key){
        try(Jedis jedis = jedisPool.getResource()){
            return jedis.exists(key);
        }
    }

}

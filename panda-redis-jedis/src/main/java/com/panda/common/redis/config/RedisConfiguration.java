package com.panda.common.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis 配置
 * @author w
 * @date 2020-06-29
 */
@Configuration
@EnableCaching
public class RedisConfiguration {

    @Autowired(required = false)
    private RedisConfig redisConfig;

    /**
     * 配置Jedis 连接池
     * @return JedisPool
     */
    @Bean
    @ConditionalOnMissingBean(JedisPool.class)
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getMaxActive());
        poolConfig.setMaxWaitMillis((redisConfig.getMaxWait()));
        return new JedisPool(poolConfig, redisConfig.getHost(),redisConfig.getPort(),redisConfig.getTimeout(),redisConfig.getPassword(),redisConfig.getDatabase());
    }
}

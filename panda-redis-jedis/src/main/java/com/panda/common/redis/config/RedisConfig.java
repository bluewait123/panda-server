package com.panda.common.redis.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Redis的配置
 * @author w
 * @date 2020-06-29
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
    /**
     * 主机
     */
    private String host;

    /**
     * 端口
     */
    private int port;

    /**
     * 超时时间
     */
    private int timeout;

    /**
     * 密码
     */
    private String password;

    /**
     * 指定数据库
     */
    private int database;

    /**
     * 最大连接数
     */
    @Value("${spring.redis.pool.max-active:12}")
    private int maxActive;

    /**
     * 最大空闲连接数
     */
    @Value("${spring.redis.pool.max-idle:12}")
    private int maxIdle;

    /**
     * 最小空闲连接数
     */
    @Value("${spring.redis.pool.min-idle:5}")
    private int minIdle;

    /**
     * 连接池最大阻塞等待时间
     */
    @Value("${spring.redis.pool.max-wait:5}")
    private int maxWait;

    @Value("${spring.redis.pool.test-on-return:true}")
    private boolean testOnReturn;

    /**
     * 在获取连接的时候检查有效性
     */
    @Value("${spring.redis.pool.test-on-borrow:true}")
    private boolean testOnBorrow;

    /**
     * 在空闲时检查有效性
     */
    @Value("${spring.redis.pool.test-while-idle:true}")
    private boolean testWhileIdle;
}

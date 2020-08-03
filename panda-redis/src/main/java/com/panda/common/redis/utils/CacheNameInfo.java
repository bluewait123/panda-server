package com.panda.common.redis.utils;

import com.panda.common.redis.vo.CacheName;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 缓存空间配置信息
 * @author w
 * @date 2020-06-29
 */
@Component
@ConfigurationProperties(prefix="spring.cache")
@Data
public class CacheNameInfo {
    private List<CacheName> names;
}
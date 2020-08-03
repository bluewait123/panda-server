package com.panda.common.redis.vo;

import lombok.Data;

/**
 * 缓存空间配置
 * @author w
 * @date 2020-06-29
 */
@Data
public class CacheName {
    /**
     * 空间名称
     */
    private String name;

    /**
     * 默认缓存有效期 单位：秒
     */
    private int expire;
}

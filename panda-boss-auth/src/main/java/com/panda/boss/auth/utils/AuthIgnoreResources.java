package com.panda.boss.auth.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 认证资源过滤
 * @author wujianhui
 */
@Data
@Component
@ConfigurationProperties(prefix = "auth.ignore")
@PropertySource(value = "file:${user.dir}/config/auth-ignore.properties", ignoreResourceNotFound = true)
public class AuthIgnoreResources {
	/**
	 * URL白名单
	 */
	private List<String> url;

	/**
	 * 资源白名单
	 */
	private List<String> resource;
}

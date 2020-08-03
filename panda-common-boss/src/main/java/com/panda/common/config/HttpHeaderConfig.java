package com.panda.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * HTTP HEADER CONFIG
 * @author w
 * @date 2020-07-08
 */
@Configuration
@Slf4j
@EnableAsync
public class HttpHeaderConfig {
    @Bean("fileSystemHttpHeaders")
    @Primary
    public HttpHeaders fileSystemHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=utf-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return headers;
    }
}

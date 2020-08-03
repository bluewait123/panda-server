package com.panda.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.panda.common.gson.NullStringToEmptyAdapterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Gson 配置
 * @author w
 * @date 2020-07-21
 */
@Configuration
@Slf4j
@EnableAsync
public class GsonConfig {
    @Bean
    @Primary
    public Gson gson() {
        /*return new GsonBuilder().serializeNulls().setPrettyPrinting().create();*/
        return  new GsonBuilder()
                .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
//                .serializeNulls()
                .create();
    }
}

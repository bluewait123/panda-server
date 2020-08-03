package com.panda.file.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件配置信息
 * @author w
 * @date 2020-07-08
 */
@Component
@ConfigurationProperties(prefix="panda.file")
@Data
public class FileConfigUtils {
    private FileConfigInfo image;
    private FileConfigInfo markdown;
    private FileConfigInfo html;
}
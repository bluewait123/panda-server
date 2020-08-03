package com.panda.file.utils;

import lombok.Data;

/**
 * 文件配置信息
 * @author w
 * @date 2020-07-08
 */
@Data
public class FileConfigInfo {

    /**
     * 本地存储路径
     */
    private String local;

    /**
     * 远程访问路径
     */
    private String remote;
}

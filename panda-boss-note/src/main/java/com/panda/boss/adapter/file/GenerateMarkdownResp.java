package com.panda.boss.adapter.file;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 生成markdown 文件响应
 * @author w
 * @date 2020-07-08
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GenerateMarkdownResp extends FileResp {
    /**
     * markdown文件ID
     */
    private String id;

    /**
     * 文件访问URL
     */
    private String url;
}

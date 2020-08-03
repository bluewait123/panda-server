package com.panda.file.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 生成markdown 文件请求
 * @author w
 * @date 2020-07-08
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GenerateMarkdownReq extends FileReq{

    /**
     * markdown 数据
     */
    private String data;
}

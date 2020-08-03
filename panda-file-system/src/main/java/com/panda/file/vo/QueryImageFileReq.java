package com.panda.file.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求查询图片文件信息
 * @author w
 * @date 2020-07-08
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class QueryImageFileReq extends FileReq{
    /**
     * 响应信息集合
     */
    private String[] ids;
}

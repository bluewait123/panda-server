package com.panda.file.vo.item;

import lombok.Data;

/**
 * 响应图片文件信息
 * @author w
 * @date 2020-07-08
 */
@Data
public class QueryImageFileItem {

    /**
     * 图片ID
     */
    private String id;

    /**
     * 原图
     */
    private String sourcePic;

    /**
     * 大图
     */
    private String bigPic;

    /**
     * 中图
     */
    private String middlePic;

    /**
     * 小图
     */
    private String smallPic;
}

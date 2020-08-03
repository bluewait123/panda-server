package com.panda.file.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 上传文件 BASE64
 * @author w
 * @date 2020-07-08
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class UploadImageStringReq extends FileReq {

    /**
     * 前端上传的BASE64字符串
     */
    private String[] files;

    /**
     * 请求图片文件类型 png/jpg/gif
     */
    private String fileType;

    /**
     * 状态
     * 0-未使用
     * 1-正在使用
     */
    private Integer status;
}

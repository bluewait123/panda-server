package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件系统交易码
 * @author w
 * @date 2020-07-08
 */
@AllArgsConstructor
@Getter
public enum FileSystemTranCodeEnum {

    /**
     * 定义交易码
     */
    GENERATE_MARKDOWN("/md/generate","生成markdown文件"),
    GET_IMAGE_FILE_INFO("/image/details","查询图片文件信息")

    ;

    private String tranCode;

    private String desc;

}

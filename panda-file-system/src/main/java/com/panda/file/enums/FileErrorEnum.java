package com.panda.file.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * FILE 通用错误信息
 * @author w
 * @date 2020-06-28
 */
@AllArgsConstructor
@Getter
public enum FileErrorEnum {

    /**
     * 定义错误信息
     */
    SUCCESS("0000","交易成功!"),
    FAIL("9999","系统繁忙,请稍后再试!"),
    NOT_NULL( "9901", "{0}参数不能为空"),

    CREATE_FOLDER_ERROR("1001","存储文件夹不存在，请核查!"),
    SAVE_FILE_INFO_ERROR("1002","保存文件信息失败，请核查!"),
    BASE64_DATA_EMPTY_ERROR("1003","BASE64数据为空!"),
    FILE_INFO_NOT_EXIST("1004","图片信息不存在!"),
    ADD_MARKDOWN_FILE_INFO_ERROR("1005","新增markdown文件信息失败!"),

    ;

    /**
     *
     */
    private String code;
    private String desc;

    public String getMsg(Object...param){
        return MessageFormat.format(desc,param);
    }
}

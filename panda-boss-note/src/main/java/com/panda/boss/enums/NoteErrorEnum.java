package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * 定义业务错误信息
 * @author w
 * @date 2020-06-28
 */
@Getter
@AllArgsConstructor
public enum NoteErrorEnum {
    /**
     * 8901 - 8999 通讯相关异常
     */
    FILE_SYSTEM_HANDLE_ERROR("8901","文件系统处理错误，详细原因[{0}]"),

    /**
     * 1001 - 1099 笔记类型
     */
    NOTE_TYPE_ADD_ERROR("1001","新增笔记种类失败，请稍后再试!"),

    /**
     * 1101 - 1199 笔记信息
     */
    NOTE_DATA_ADD_ERROR("1101","新增笔记失败，请稍后再试!"),
    NOTE_DATA_NOT_EXITS("1102","笔记信息不存在!"),





    ;

    private String code;
    private String desc;

    public String getMsg(Object...param){
        return MessageFormat.format(desc,param);
    }
}

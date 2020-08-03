package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记状态枚举
 * @author w
 * @date 2020-07-06
 */
@AllArgsConstructor
@Getter
public enum NoteDataStatusEnum {

    /**
     * 状态配置
     */
    DELETE(0,"删除"),
    NORMAL(1, "正常"),

    ;

    private Integer code;
    private String desc;
}

package com.panda.file.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * markdown文件状态
 * @author w
 * @date 2020-07-08
 */
@AllArgsConstructor
@Getter
public enum MarkdownFileStatusEnums {

    /**
     * 状态
     * 0-未使用
     * 1-正在使用
     * 2-已删除
     */
    NONE(0,"未使用"),
    USE(1,"正在使用"),
    DEL(2,"已删除"),

    ;

    private Integer code;
    private String desc;
}

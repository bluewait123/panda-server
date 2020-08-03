package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记类型状态枚举
 * @author w
 * @date 2020-07-06
 */
@AllArgsConstructor
@Getter
public enum NoteTypeStatusEnum {

    /**
     * 状态配置
     */
    ENABLE(1,"有效"),
    DISABLE(0, "禁用"),

    ;

    private Integer code;
    private String desc;
}

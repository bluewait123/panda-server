package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 笔记种类状态枚举
 * @author w
 * @date 2020-07-06
 */
@AllArgsConstructor
@Getter
public enum NotePublicTypeEnum {
    /**
     * 发布类型配置
     * 0-私有
     * 1-匿名访问
     * 2-带认证口令访问
     */
    PRIVATE(0,"私有"),
    PUBLIC(1, "匿名访问"),
    AUTH(2,"带认证口令访问")

    ;

    private Integer code;
    private String desc;
}

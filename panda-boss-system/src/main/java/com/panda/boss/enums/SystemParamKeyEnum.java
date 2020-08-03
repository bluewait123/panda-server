package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统参数编码KEY
 * @author w
 * @date 2020-07-01
 */
@AllArgsConstructor
@Getter
public enum SystemParamKeyEnum {

    /**
     * 定义
     */
    LOGIN_AUTH_TIME_OUT("LOGIN_AUTH_TIME_OUT","登录认证有效时间（秒）"),

    ;
    private String code;
    private String desc;

}

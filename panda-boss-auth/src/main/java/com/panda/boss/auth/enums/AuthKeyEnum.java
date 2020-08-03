package com.panda.boss.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 定义认证相关key
 * @author w
 * @date 2020-07-01
 */
@AllArgsConstructor
@Getter
public enum AuthKeyEnum {
    /**
     * 定义认证相关key
     */
    TOKEN("token","登录认证ToKen"),
    USER_INFO("userInfo","登录用户信息"),
    USER_ID("userId","登录用户ID")

    ;

    private String code;
    private String desc;
}

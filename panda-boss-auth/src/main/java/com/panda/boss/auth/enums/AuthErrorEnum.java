package com.panda.boss.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * 定义认证错误信息
 * @author w
 * @date 2020-07-01
 */
@Getter
@AllArgsConstructor
public enum AuthErrorEnum {

    /**
     * 定义错误信息
     */
    USER_INFO_NOT_EXIST("AUTH_TIME_OUT","登录超时!"),
    TOKEN_NOT_EXIST("9801","非法请求!"),
    AUTH_RESOURCE_NOT_EXIST("9802","非法请求!"),


    ;

    private String code;
    private String desc;

    public String getMsg(Object...param){
        return MessageFormat.format(desc,param);
    }
}

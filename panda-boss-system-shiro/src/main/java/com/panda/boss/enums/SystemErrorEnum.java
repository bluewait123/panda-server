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
public enum SystemErrorEnum {
    /**
     * 9900-9999 系统相关
     */
    AUTH_ERROR("9901","认证失败，详细原因:{0}"),

    /**
     * 1001-1100 用户相关
     */
    USER_NOT_EXITS_OR_PWD_ERROR("1001","用户不存在或密码错误!"),


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

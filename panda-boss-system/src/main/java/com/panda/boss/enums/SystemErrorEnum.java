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
     * 1001 - 1099 用户相关
     */
    USER_NOT_EXITS_OR_PWD_ERROR("1001","用户不存在或密码错误!"),
    USER_STATUS_LOCK_ERROR("1002","您的账号已被锁定，请联系管理员重置密码!"),
    USER_STATUS_DISABLE_ERROR("1003","您的账号已被禁用，请联系管理员!"),
    USER_STATUS_UNKNOWN_ERROR("1004","您的账号状态异常，请联系管理员!"),

    /**
     * 1201 -1299 角色相关
     */
    ROLE_NOT_EXITS_ERROR("1201","角色信息不存在!"),

    ;

    private String code;
    private String desc;

    public String getMsg(Object...param){
        return MessageFormat.format(desc,param);
    }
}

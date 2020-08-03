package com.panda.boss.auth.constant;

import java.text.MessageFormat;

/**
 * Auth Redis Key
 * @date 2020-07-01
 * @author wujianhui
 */
public class AuthRedisKey {
    private final static String PROJECT_PREFIX = "panda:boss:auth";

    /**
     * 获取登录用户信息
     * @param token 登录票据
     * @return String
     */
    public static String getSessionUserInfoKey(String token){
        return MessageFormat.format("{0}:user:info:{1}",PROJECT_PREFIX,token);
    }

    /**
     * 获取用户授权资源信息KEY
     * @param userId 用户ID
     * @return String
     */
    public static String getUserAuthResourceKey(String userId){
        return MessageFormat.format("{0}:resource:user:menus:{1}",PROJECT_PREFIX,userId);
    }

    /**
     * 获取登录用户有效期
     * @param userId 用户ID
     * @return String
     */
    public static String getUserAuthTimeOutKey(String userId){
        return MessageFormat.format("{0}:user:timeout:{1}",PROJECT_PREFIX,userId);
    }
}

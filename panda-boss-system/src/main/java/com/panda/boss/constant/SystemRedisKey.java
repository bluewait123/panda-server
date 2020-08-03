package com.panda.boss.constant;

import java.text.MessageFormat;

public class SystemRedisKey {
    private final static String PROJECT_PREFIX = "panda:boss:system";

    /**
     * 获取系统参数信息KEY
     * @param paraCode 参数编码
     * @return String
     */
    public static String getSystemParamKey(String paraCode){
        return MessageFormat.format("{0}:parameter:{1}",PROJECT_PREFIX,paraCode);
    }

    /**
     * 检查系统参数信息KEY
     * @return String
     */
    public static String checkSystemParamKey(){
        return MessageFormat.format("{0}:parameter:check",PROJECT_PREFIX);
    }

    /**
     * 获取系统资源信息KEY
     * @param roleId 角色ID
     * @return String
     */
    public static String getSystemResourceKey(String roleId){
        return MessageFormat.format("{0}:resource:{1}",PROJECT_PREFIX,roleId);
    }

    /**
     * 检查系统资源信息KEY
     * @return String
     */
    public static String checkSystemResourceKey(){
        return MessageFormat.format("{0}:resource:check",PROJECT_PREFIX);
    }
}

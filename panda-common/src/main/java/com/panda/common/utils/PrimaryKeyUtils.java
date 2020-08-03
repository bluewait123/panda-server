package com.panda.common.utils;

import java.util.UUID;

/**
 * 主键相关工具包
 * @author wujianhui
 * @date 2019/07/23
 */
public class PrimaryKeyUtils {

    /**
     * 获取UUID
     * @return
     */
    public static String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.println(getUuid());
        }
    }

}

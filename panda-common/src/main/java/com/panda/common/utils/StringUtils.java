package com.panda.common.utils;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

/**
 * 字符串工具包
 * @author w
 * @date 2020-06-28
 */
public class StringUtils {

    /**
     * 判断对象是否不为空
     * @param data 对象
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object data){
        return !isEmpty(data);
    }

    /**
     * 判断对象是否为空
     * @param data 对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object data){
        if(null == data){
            return true;
        }

        if(data instanceof String){
            String str = (String)data;
            if("".equals(str)){
                return true;
            }
            return org.apache.commons.lang.StringUtils.isBlank(str);
        }

        if(data instanceof Collection){
            return ((Collection)data).isEmpty();
        }

        if (data instanceof Dictionary) {
            return ((Dictionary<?, ?>) data).isEmpty();
        }

        if (data instanceof Map) {
            return ((Map<?, ?>) data).isEmpty();
        }

        return false;
    }
}

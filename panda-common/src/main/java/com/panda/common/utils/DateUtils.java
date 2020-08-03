package com.panda.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 格式定义
     */
    public static final String FORMAT = "yyyyMMddHHmmss";
    public static final String FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE1 = "yyyyMMdd";
    public static final String DATE2 = "yyyy-MM-dd";
    public static final String TIME1 = "HHmmss";
    public static final String TIME2 = "HH:mm:ss";
    public static final String YEAR = "yyyy";
    public static final String MONTH = "MM";
    public static final String DAY = "dd";
    public static final String HOUR = "HH";
    public static final String MINUTE = "HH";
    public static final String SECOND = "HH";
    public static final String YYYYMM = "yyyyMM";

    /**
     * 格式化日期
     * @param format 日期格式
     * @param date 日期
     * @return String
     */
    public static String formatDate(String format, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取当前日期
     * @return String
     */
    public static String getCurrentDate(String format){
        return formatDate(format,new Date());
    }

}

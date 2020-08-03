package com.panda.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * BOSS 通用错误信息
 * @author w
 * @date 2020-06-28
 */
@AllArgsConstructor
@Getter
public enum BossErrorEnum {

    /**
     * 定义错误信息
     */
    SUCCESS("0000","交易成功!"),
    FAIL("9999","系统繁忙,请稍后再试!"),
    NOT_NULL( "9901", "{0}参数不能为空"),

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

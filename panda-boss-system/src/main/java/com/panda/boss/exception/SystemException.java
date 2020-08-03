package com.panda.boss.exception;

import com.panda.boss.enums.SystemErrorEnum;
import com.panda.common.exception.BossException;

public class SystemException extends BossException {

    /**
     * 响应错误信息
     * @param error 错误信息
     * @param param 格式化参数
     */
    public SystemException(SystemErrorEnum error, Object...param){
        super(error.getCode(),error.getMsg(param));
    }
}

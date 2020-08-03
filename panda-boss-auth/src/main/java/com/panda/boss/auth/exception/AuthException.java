package com.panda.boss.auth.exception;

import com.panda.boss.auth.enums.AuthErrorEnum;
import com.panda.common.exception.BossException;

public class AuthException extends BossException {

    /**
     * 响应错误信息
     * @param error 错误信息
     * @param param 格式化参数
     */
    public AuthException(AuthErrorEnum error, Object...param){
        super(error.getCode(),error.getMsg(param));
    }
}

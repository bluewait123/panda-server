package com.panda.boss.exception;

import com.panda.boss.enums.NoteErrorEnum;
import com.panda.common.exception.BossException;

public class NoteException extends BossException {

    /**
     * 响应错误信息
     * @param error 错误信息
     * @param param 格式化参数
     */
    public NoteException(NoteErrorEnum error, Object...param){
        super(error.getCode(),error.getMsg(param));
    }
}

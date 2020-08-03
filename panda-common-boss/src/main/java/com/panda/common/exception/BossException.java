package com.panda.common.exception;

import com.panda.common.enums.BossErrorEnum;
import lombok.Getter;

/**
 * BOSS 通用异常信息
 * @author w
 * @date 2020-06-28
 */
@Getter
public class BossException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 响应码
     */
    private String respCode;

    /**
     * 响应信息
     */
    private String respDesc;

    /**
     * 异常来源
     */
    private Throwable source;

    public BossException(String respCode, String respDesc){
        super(respDesc);
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public BossException(Throwable source, String respCode, String respDesc){
        super(respDesc);
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.source = source;
    }

    public BossException(BossErrorEnum error, Object...param){
        super(error.getMsg(param));
        this.respCode = error.getCode();
        this.respDesc = super.getMessage();
    }

    public BossException(Throwable source, BossErrorEnum error, Object...param){
        super(error.getMsg(param));
        this.respCode = error.getCode();
        this.respDesc = super.getMessage();
        this.source = source;
    }
}

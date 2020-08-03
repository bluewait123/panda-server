package com.panda.file.exception;

import com.panda.file.enums.FileErrorEnum;
import lombok.Getter;

/**
 * BOSS 通用异常信息
 * @author w
 * @date 2020-06-28
 */
@Getter
public class FileException extends RuntimeException {
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

    public FileException(String respCode, String respDesc){
        super(respDesc);
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public FileException(Throwable source, String respCode, String respDesc){
        super(respDesc);
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.source = source;
    }

    public FileException(FileErrorEnum error, Object...param){
        super(error.getMsg(param));
        this.respCode = error.getCode();
        this.respDesc = super.getMessage();
    }

    public FileException(Throwable source, FileErrorEnum error, Object...param){
        super(error.getMsg(param));
        this.respCode = error.getCode();
        this.respDesc = super.getMessage();
        this.source = source;
    }
}

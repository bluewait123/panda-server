package com.panda.file.controller;

import com.panda.file.enums.FileErrorEnum;
import com.panda.file.exception.FileException;
import com.panda.file.vo.FileResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 公共控制器(包含全局异常处理)
 * @author w
 * @date 2020-06-28
 */
@Slf4j
public class BasicController {
    public FileResp assemble(String code, String desc){
        FileResp resp = new FileResp();
        resp.setCode(code);
        resp.setMsg(desc);
        return resp;
    }

    public FileResp assemble(Object data){
        FileResp resp = assemble(FileErrorEnum.SUCCESS.getCode(),FileErrorEnum.SUCCESS.getDesc());
        resp.setData(data);
        return resp;
    }

    public FileResp assemble(){
        return assemble(FileErrorEnum.SUCCESS.getCode(),FileErrorEnum.SUCCESS.getDesc());
    }

    /**
     * 全局异常处理
     * @param request HTTP 请求信息
     * @param ex 异常信息
     * @return BossResp 转换后的响应信息
     */
    @ExceptionHandler(value = { Exception.class, Throwable.class })
    public @ResponseBody FileResp handleException(HttpServletRequest request, Throwable ex) {
        log.error(ex.getMessage(), ex);
        // 自定义异常类型
        if (ex instanceof FileException) {
            FileException be = (FileException) ex;
            if(null != be.getSource()){
                log.error(be.getMessage(),be.getSource());
            }
            return assemble(be.getRespCode(), be.getRespDesc());
        }else{
            // 通用错误类型
            return assemble(FileErrorEnum.FAIL.getCode(),FileErrorEnum.FAIL.getDesc());
        }
    }
}

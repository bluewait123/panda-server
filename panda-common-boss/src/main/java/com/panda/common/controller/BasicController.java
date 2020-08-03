package com.panda.common.controller;

import com.github.pagehelper.PageInfo;
import com.panda.common.enums.BossErrorEnum;
import com.panda.common.exception.BossException;
import com.panda.common.vo.BossPageResp;
import com.panda.common.vo.BossResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${system.type:common}")
    private String systemType;

    public BossResp assemble(String code, String desc){
        BossResp resp = new BossResp();
        resp.setCode(code);
        resp.setMsg(desc);
        resp.setSystem(systemType);
        return resp;
    }

    public BossResp assemble(PageInfo<?> pageInfo){
        BossPageResp resp = new BossPageResp();
        resp.setCode(BossErrorEnum.SUCCESS.getCode());
        resp.setMsg(BossErrorEnum.SUCCESS.getDesc());
        resp.setPaging(pageInfo);
        resp.setData(pageInfo.getList());
        return resp;
    }

    public BossResp assemble(Object data){
        BossResp resp = assemble(BossErrorEnum.SUCCESS.getCode(),BossErrorEnum.SUCCESS.getDesc());
        resp.setData(data);
        return resp;
    }

    public BossResp assemble(){
        return assemble(BossErrorEnum.SUCCESS.getCode(),BossErrorEnum.SUCCESS.getDesc());
    }

    /**
     * 全局异常处理
     * @param request HTTP 请求信息
     * @param ex 异常信息
     * @return BossResp 转换后的响应信息
     */
    @ExceptionHandler(value = { Exception.class, Throwable.class })
    public @ResponseBody BossResp handleException(HttpServletRequest request, Throwable ex) {
        log.error(ex.getMessage(), ex);
        // 自定义异常类型
        if (ex instanceof BossException) {
            BossException be = (BossException) ex;
            if(null != be.getSource()){
                log.error(be.getMessage(),be.getSource());
            }
            return assemble(be.getRespCode(), be.getRespDesc());
        }else{
            // 通用错误类型
            return assemble(BossErrorEnum.FAIL.getCode(),BossErrorEnum.FAIL.getDesc());
        }
    }
}

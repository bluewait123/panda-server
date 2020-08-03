package com.panda.demo.mock.enums;

import com.panda.demo.mock.logic.LogicService;
import com.panda.demo.mock.logic.QueryBlackListLogicImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 龙江ESB交易码对照
 * @author w
 */
@AllArgsConstructor
@Getter
public enum  LongJiangEsbTranCode {

    /**
     *
     */
    BLACK_LIST("S000001001000101", QueryBlackListLogicImpl.class,"黑名单查询")

    ;

    /**
     * ESB 服务代码
     */
    private String esbCode;

    /**
     * 业务处理类
     */
    private Class<? extends LogicService> logic;

    /**
     * 描述
     */
    private String desc;

    public static LongJiangEsbTranCode getTranCode(String esbCode){
        LongJiangEsbTranCode e = null;
        for(LongJiangEsbTranCode tranCode : values()){
            if(tranCode.getEsbCode().equals(esbCode)){
                e = tranCode;
                break;
            }
        }
        return e;
    }
}

package com.panda.common.vo;

import com.panda.common.vo.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BOSS 响应公共信息
 * @author w
 * @date 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BossResp extends Response {

    /**
     * 对应系统
     */
    private String system;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应描述信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;
}

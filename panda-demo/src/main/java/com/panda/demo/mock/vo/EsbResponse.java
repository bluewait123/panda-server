package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * ESB 响应信息公共配置
 * @author w
 * @date 2020-07-20
 * @param <Body> 响应报文体
 */
@Data
public class EsbResponse<Body extends EsbBodyResp> {

    /**
     * 业务报文头
     */
    @SerializedName("RspBusiHeader")
    private EsbBusinessHeaderResp businessHeader;

    /**
     * 通用报文头
     */
    @SerializedName("RspCommHeader")
    private EsbCommonHeaderResp commonHeader;

    /**
     * 响应报文体
     */
    @SerializedName("RspBody")
    private Body body;
}

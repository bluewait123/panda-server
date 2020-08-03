package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * ESB 请求信息公共配置
 * @author w
 * @date 2020-07-20
 * @param <Body> 请求报文体
 */
@Data
public class EsbRequest<Body extends EsbBodyReq>{
    /**
     * 通用报文头
     */
    @SerializedName("ReqCommHeader")
    private EsbCommonHeaderReq commonHeader;

    /**
     * 业务报文头
     */
    @SerializedName("ReqBusiHeader")
    private EsbBusinessHeaderReq businessHeader;

    /**
     * 请求参数主体信息
     */
    @SerializedName("ReqBody")
    private Body body;

    public EsbRequest(){
        this.initCommonHeaderReq(this.commonHeader);
        this.initBusinessHeader(this.businessHeader);
    }

    public EsbRequest(Body reqBody){
        this.initCommonHeaderReq(this.commonHeader);
        this.initBusinessHeader(this.businessHeader);
        this.body = reqBody;
    }

    public EsbRequest(EsbCommonHeaderReq reqCommonHeader, EsbBusinessHeaderReq reqBusinessHeader,Body reqBody){
        this.commonHeader = reqCommonHeader;
        this.businessHeader = reqBusinessHeader;
        this.body = reqBody;
    }

    /**
     * 创建ESB 业务请求报文头
     */
    private void initBusinessHeader(EsbBusinessHeaderReq req){
        this.businessHeader = null == req ? new EsbBusinessHeaderReq() : req;
    }

    /**
     * 创建ESB 通用请求报文头
     */
    private void initCommonHeaderReq(EsbCommonHeaderReq req){
        this.commonHeader = null == req ? new EsbCommonHeaderReq() : req;
    }

}

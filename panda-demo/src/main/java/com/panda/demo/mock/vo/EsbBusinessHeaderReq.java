package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * ESB 请求业务报文头
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbBusinessHeaderReq {

    /**
     * 原始发起方业务日
     * 联机交易原始发起方系统的业务日期
     */
    @SerializedName("OrgBusiDate")
    private String orgBusinessDate;

    /**
     * 原始发起方系统流水号
     * 原始发起方系统生成的本笔交易流水号。
     */
    @SerializedName("OrgSeqNo")
    private String orgSeqNo;

    /**
     * 全局事件跟踪号
     */
    @SerializedName("EvtTraceId")
    private String evtTraceId;

    /**
     * 服务调用方业务日期
     * 联机交易服务调用方系统的业务日期。
     */
    @SerializedName("ReqBusiDate")
    private String reqBusinessDate;

    /**
     * 服务调用方系统流水号
     * 服务调用方系统生成的本笔交易流水号。
     */
    @SerializedName("ReqSeqNo")
    private String reqSeqNo;

    /**
     * 交易柜员号
     * 本笔交易的交易柜员号。
     */
    @SerializedName("TellerNo")
    private String tellerNo;

    /**
     * 交易机构码
     * 本笔交易的交易柜员归属机构。
     */
    @SerializedName("BrchNo")
    private String branchNo;

    /**
     * 交易柜员密码
     */
    @SerializedName("TellerPwd")
    private String tellerPwd;

    /**
     * 交易柜员级别
     */
    @SerializedName("TellerLvl")
    private String tellerLvl;

    /**
     * 复核标志
     * 1-已复核
     * 空或其他-未复核
     */
    @SerializedName("ApprFalg")
    private String apprFalg;

    /**
     * 复核标志为“1”（已复核）时，在此上送录入柜员信息，循环报文
     */
    @SerializedName("InputTelleInfoArray")
    private List<EsbInputTellerInfoArray> inputTellerInfoArray;

    /**
     * 授权标志
     * 1-已授权
     * 空或其他-未授权
     */
    @SerializedName("AuthFlag")
    private String authFlag;

    /**
     * 授权标志为“1”（已授权）时，在此上送授权柜员信息，循环报文
     */
    @SerializedName("AuthTellerInfoArray")
    private List<EsbAuthTellerInfoArray> authTellerInfoArray;

    /**
     * 多页查询方式
     * 1-计算型多页查询
     * 2-寻址型多页查询
     * 3-非多页查询
     */
    @SerializedName("MltPageQryMode")
    private String mltPageQryMode;

    /**
     * 查询页数
     * 多页查询方式为“1”（计算型多页查询）时，在此上送本次查询的页数。
     */
    @SerializedName("QryPageNum")
    private String qryPageNum;

    /**
     * 查询最大记录数
     * 多页查询方式为“1”（计算型多页查询）时，在此上送每页笔数；
     * 多页查询方式为“2”（寻址型多页查询）时，在此上送本次查询返回最大记录数。
     */
    @SerializedName("QryMaxRecNum")
    private String qryMaxRecNum;

    /**
     * 上次查询最后一笔键值
     * 多页查询方式为“2”（寻址型多页查询）时，在此上送上次服务提供方系统返回最后一条记录的键值，初次查询本字段为空。
     */
    @SerializedName("LastRecKeyValue")
    private String lastRecKeyValue;

    /**
     * 请求文件数量
     * 请求文件的数量，无请求文件上送0。
     */
    @SerializedName("ReqFileNum")
    private String reqFileNum;

    /**
     * 请求文件数量大于0时，在此上送请求文件信息，循环报文
     */
    @SerializedName("ReqFileInfoArray")
    private List<EsbReqFileInfoArray> reqFileInfoArray;

}

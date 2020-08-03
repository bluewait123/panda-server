package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * ESB 请求通用报文头
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbCommonHeaderReq implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 服务代码
     * ESB系统发布服务的服务码的前16个字节。
     */
    @SerializedName("SvcCode")
    private String svcCode;

    /**
     * 场景编码
     * ESB系统发布服务的服务码的17-18字节
     */
    @SerializedName("SvcSceneCode")
    private String svcSceneCode;

    /**
     * 原始发起方系统编码
     * 联机交易原始发起方系统的系统编码，如一笔联机交易从柜面系统发起，则在此上送柜面系统的系统编码。
     */
    @SerializedName("OrgSysId")
    private String orgSysId;

    /**
     * 原始发起方渠道类型
     * 联机交易原始发起方系统的渠道类型，如柜面渠道、电子银行渠道、自助设备渠道、合作方渠道（人行、银联等）等。
     */
    @SerializedName("OrgChnlType")
    private String orgChannelType;

    /**
     * 原始发起方系统交易日期
     * 联机交易原始发起方系统的系统日期。
     */
    @SerializedName("OrgTranDate")
    private String orgTranDate;

    /**
     * 原始发起方交易时间
     * 联机交易原始发起方系统的系统时间。
     */
    @SerializedName("OrgTranTime")
    private String orgTranTime;

    /**
     * 原始发起方系统终端编号
     * 原始发起方系统交易发起柜员签到的终端设备编号。
     */
    @SerializedName("OrgTrmNo")
    private String orgTrmNo;

    /**
     * 原始发起方系统安全节点号
     * 预留字段，根据龙江银行新一代系统的内部系统间通讯安全处理要求，确定本字段是否需要保留。
     */
    @SerializedName("OrgSysSecId")
    private String orgSysSecId;

    /**
     * 服务调用方系统编码
     * 直接调用实体ESB系统服务的业务系统的系统编码，如果是原始发起方系统直接访问实体ESB系统，则本字段和原始发起方系统编码字段一致，否则为本次服务对应的服务调用方系统的系统编码。
     */
    @SerializedName("ReqSysId")
    private String reqSysId;

    /**
     * 服务调用方系统交易日期
     * 服务调用方系统完成本次交易的系统日期。
     */
    @SerializedName("ReqTranDate")
    private String reqTranDate;

    /**
     * 服务调用方系统交易时间
     * 服务调用方系统完成本次交易的系统时间。
     */
    @SerializedName("ReqTranTime")
    private String reqTranTime;

    /**
     * 服务调用方系统终端编号
     */
    @SerializedName("ReqTrmNo")
    private String reqTrmNo;

    /**
     * 服务调用方系统安全节点号
     * 预留字段，根据龙江银行新一代系统的内部系统间通讯安全处理要求，确定本字段是否需要保留。
     */
    @SerializedName("ReqSysSecId")
    private String reqSysSecId;

    /**
     * 用户语言
     * Chinese-中文（默认）
     * English-英文
     */
    @SerializedName("UserLanguage")
    private String userLanguage;

    /**
     * 报文验证码
     * 预留字段，如果需要，在此存放应用数字签名、报文Mac、MD5散列值等报文数据安全校验字段。
     */
    @SerializedName("MsgChkCode")
    private String msgChkCode;

}

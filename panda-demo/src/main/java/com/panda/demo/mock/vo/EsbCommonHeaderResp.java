package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * ESB 响应通用报文头
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbCommonHeaderResp {

    /**
     * 服务代码
     * 同请求报文通用报文头。
     */
    @SerializedName("SvcCode")
    private String svcCode;

    /**
     * 场景编码
     * 同请求报文通用报文头。
     */
    @SerializedName("SvcSceneCode")
    private String svcSceneCode;

    /**
     * 服务提供方系统编码
     * 联机交易服务提供方系统的系统编码。
     */
    @SerializedName("SvcSysId")
    private String svcSysId;

    /**
     * 服务提供方系统交易日期
     * 联机交易服务提供方系统的系统日期。
     */
    @SerializedName("SvcTranDate")
    private String svcTranDate;

    /**
     * 服务提供方交易时间
     * 联机交易服务提供方系统的系统时间。
     */
    @SerializedName("SvcTranTime")
    private String svcTranTime;

    /**
     * 服务提供方系统安全节点号
     * 预留字段，根据龙江银行新一代系统的内部系统间通讯安全处理要求，确定本字段是否需要保留。
     */
    @SerializedName("SvcSysSecId")
    private String svcSysSecId;

    /**
     * 服务处理状态
     * S-处理成功
     * F-处理失败
     * R-处理超时
     * E-异常（收到后续系统处理成功但某一处理节点成功后处理未成功）
     */
    @SerializedName("SvcStat")
    private String svcStat;

    /**
     * 最后处理系统编码
     * 本笔联机交易最后完成处理的业务系统的系统编码。
     */
    @SerializedName("LastSysId")
    private String lastSysId;

    /**
     * 服务响应信息，循环报文
     */
    @SerializedName("RspMsgArray")
    private List<EsbRspMsgArray> rspMsgArray;

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

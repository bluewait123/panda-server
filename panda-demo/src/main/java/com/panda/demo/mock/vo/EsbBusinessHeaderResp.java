package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * ESB 响应业务报文头
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbBusinessHeaderResp {

    /**
     * 服务提供方业务日期
     * 联机交易服务提供方系统的业务日期。
     */
    @SerializedName("SvcBusiDate")
    private String svcBusinessDate;

    /**
     * 服务提供方系统流水号
     * 服务提供方系统生成的本笔交易流水号。
     */
    @SerializedName("SvcSeqNo")
    private String svcSeqNo;

    /**
     * 多页查询方式
     * 1-计算型多页查询
     * 2-寻址型多页查询
     * 3-非多页查询
     */
    @SerializedName("MltPageQryMode")
    private String mltPageQryMode;

    /**
     * 总页数
     * 多页查询方式为“1”（计算型多页查询）时，在此返回本次查询结果集的总页数。
     */
    @SerializedName("TotPageNum")
    private String totPageNum;

    /**
     * 当前页
     * 多页查询方式为“1”（计算型多页查询）时，在此返回本次查询返回的页数。
     */
    @SerializedName("CurrPageNum")
    private String currPageNum;

    /**
     * 查询记录数
     * 多页查询方式为“1”（计算型多页查询）、“2”（寻址型多页查询）时，在此返回本次查询返回记录数。
     */
    @SerializedName("RecNum")
    private String recNum;

    /**
     * 首笔键值
     * 多页查询方式为“2”（寻址型多页查询）时，在此返回本次返回记录第一笔记录键值。
     */
    @SerializedName("FirstRecKeyValue")
    private String firstRecKeyValue;

    /**
     * 最后一笔键值
     * 多页查询方式为“2”（寻址型多页查询）时，在此返回本次返回记录最后一笔记录键值。
     */
    @SerializedName("LastRecKeyValue")
    private String lastRecKeyValue;

    /**
     * 响应文件数量
     * 响应文件的数量，无响应文件返回0。
     */
    @SerializedName("RspFileNum")
    private String rspFileNum;

    /**
     * 响应文件数量大于0时，在此返回响应文件信息，循环报文
     */
    @SerializedName("RspFileInfoArray")
    private List<EsbRspFileInfoArray> rspFileInfoArray;
}

package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 响应文件数量大于0时，在此返回响应文件信息，循环报文
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbRspFileInfoArray {

    /**
     * 响应文件名称
     */
    @SerializedName("RspFileName")
    private String rspFileName;

    /**
     * 响应文件大小
     * 响应文件以字节为单位的大小，接收方校验使用
     */
    @SerializedName("RspFileSize")
    private String rspFileSize;

    /**
     * 响应文件校验码
     * 文件提供方、接收方约定的对传输文件校验的校验码，如MD5散列值，是否需要由双方系统约定。
     */
    @SerializedName("RspFileChkCode")
    private String rspFileChkCode;
}

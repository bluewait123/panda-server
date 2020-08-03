package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 服务响应信息，循环报文
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbRspMsgArray {

    /**
     * 响应码
     * 000000-交易成功
     * 其他-处理失败（返回格式为:响应码赋值的业务系统编码-该系统生成的响应码）
     */
    @SerializedName("RspCode")
    private String rspCode;

    /**
     * 响应信息
     */
    @SerializedName("RspMsg")
    private String rspMsg;
}

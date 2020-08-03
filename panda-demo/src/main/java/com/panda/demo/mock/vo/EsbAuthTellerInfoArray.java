package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 授权标志为“1”（已授权）时，在此上送授权柜员信息，循环报文
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbAuthTellerInfoArray {
    /**
     * 授权柜员号
     */
    @SerializedName("AuthTellerNo")
    private String authTellerNo;

    /**
     * 授权机构码
     */
    @SerializedName("AuthBrchNo")
    private String authBranchNo;

    /**
     * 授权柜员密码
     */
    @SerializedName("AuthTellerPwd")
    private String authTellerPwd;

    /**
     * 授权柜员级别
     */
    @SerializedName("AuthTellerLvl")
    private String authTellerLvl;
}

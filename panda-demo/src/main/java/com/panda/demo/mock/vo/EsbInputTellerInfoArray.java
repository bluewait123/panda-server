package com.panda.demo.mock.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 复核标志为“1”（已复核）时，在此上送录入柜员信息，循环报文
 * @author w
 * @date 2020-07-20
 */
@Data
public class EsbInputTellerInfoArray {

    /**
     * 录入柜员号
     */
    @SerializedName("InputTellerNo")
    private String inputTellerNo;

    /**
     * 录入机构码
     */
    @SerializedName("InputBrchNo")
    private String inputBranchNo;

    /**
     * 录入柜员密码
     */
    @SerializedName("InputTellerPwd")
    private String inputTellerPwd;

    /**
     * 录入柜员级别
     */
    @SerializedName("InputTellerLvl")
    private String inputTellerLvl;
}

package com.panda.demo.mock;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.panda.common.utils.SpringContextUtils;
import com.panda.demo.mock.enums.LongJiangEsbTranCode;
import com.panda.demo.mock.logic.LogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 龙江ESB模拟
 * @author w
 * @date 2020-07-21
 */
@RequestMapping("/longjiang")
@Slf4j
@RestController
public class LongJiangEsbController {
    private static final String ESB_SUCCESS_CODE = "000000";

    @RequestMapping(value = "/esb", method = RequestMethod.POST)
    @ResponseBody
    public String esb(@RequestBody String reqData){
        JSONObject jsonObject = JSONObject.parseObject(reqData);
        JSONObject commonHeaderResp;
        JSONObject bodyResp;
        try{
            JSONObject commonHeader = jsonObject.getJSONObject("ReqCommHeader");
            // 服务编码
            String svcCode = commonHeader.getString("SvcCode");
            // 交易码对照
            LongJiangEsbTranCode tranCode = LongJiangEsbTranCode.getTranCode(svcCode);
            Optional.ofNullable(tranCode).orElseThrow(() -> new Exception("交易信息不存在!"));

            // 执行业务处理
            LogicService logicService = SpringContextUtils.getBean(tranCode.getLogic());
            String respBodyJson = logicService.execute(jsonObject);
            bodyResp = JSONObject.parseObject(respBodyJson);
            commonHeaderResp = createCommonheader(jsonObject,ESB_SUCCESS_CODE,"交易成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            bodyResp = new JSONObject();
            commonHeaderResp = createCommonheader(jsonObject,"999999",e.getMessage());
        }

        JSONObject response = new JSONObject();
        response.put("RspCommHeader",commonHeaderResp);
        response.put("RspBusiHeader",createBusinessHeader(jsonObject));
        response.put("RspBody",bodyResp);
        return response.toJSONString();
    }

    private JSONObject createCommonheader(JSONObject jsonObject, String respCode,String respMsg){
        JSONObject commonHeaderReq = jsonObject.getJSONObject("ReqCommHeader");
        JSONObject commonHeaderResp = new JSONObject();

        // 通用信息
        commonHeaderResp.put("SvcCode",commonHeaderReq.get("SvcCode"));
        commonHeaderResp.put("SvcSceneCode",commonHeaderReq.get("ReqSysSecId"));
        commonHeaderResp.put("SvcSysId",commonHeaderReq.get("ReqSysId"));
        commonHeaderResp.put("SvcTranDate",commonHeaderReq.get("OrgTranDate"));
        commonHeaderResp.put("SvcTranTime",commonHeaderReq.get("OrgTranTime"));
        commonHeaderResp.put("SvcSysSecId",commonHeaderReq.get("SvcSysSecId"));
        commonHeaderResp.put("LastSysId",commonHeaderReq.get("ReqSysId"));
        commonHeaderResp.put("UserLanguage",commonHeaderReq.get("UserLanguage"));
        commonHeaderResp.put("MsgChkCode",commonHeaderReq.get("MsgChkCode"));

        // 响应状态
        JSONArray respMsgArray = new JSONArray();
        JSONObject respMsgObject = new JSONObject();
        respMsgObject.put("RspCode",respCode);
        respMsgObject.put("RspMsg",respMsg);
        respMsgArray.add(respMsgObject);
        commonHeaderResp.put("RspMsgArray",respMsgArray);
        commonHeaderResp.put("SvcStat",ESB_SUCCESS_CODE.equals(respCode) ? "S" : "E");
        return commonHeaderResp;
    }

    private JSONObject createBusinessHeader(JSONObject jsonObject){
        JSONObject businessHeaderResp = new JSONObject();
        JSONObject businessHeaderReq = jsonObject.getJSONObject("ReqBusiHeader");
        businessHeaderResp.put("SvcBusiDate",businessHeaderReq.get("ReqBusiDate"));
        businessHeaderResp.put("SvcSeqNo",businessHeaderReq.get("ReqSeqNo"));
        businessHeaderResp.put("MltPageQryMode",businessHeaderReq.get("MltPageQryMode"));
        businessHeaderResp.put("TotPageNum",businessHeaderReq.get("1"));
        businessHeaderResp.put("CurrPageNum",businessHeaderReq.get("QryPageNum"));
        businessHeaderResp.put("RecNum",businessHeaderReq.get("1"));
        businessHeaderResp.put("FirstRecKeyValue",businessHeaderReq.get("LastRecKeyValue"));
        businessHeaderResp.put("LastRecKeyValue",businessHeaderReq.get("LastRecKeyValue"));
        return businessHeaderResp;
    }

}

package com.panda.demo.mock.logic;

import com.alibaba.fastjson.JSONObject;

/**
 * 业务处理
 * @author w
 */
public interface LogicService {
    /**
     * 执行业务处理
     * @param reqData 请求信息
     */
    String execute(JSONObject reqData) throws Exception;
}

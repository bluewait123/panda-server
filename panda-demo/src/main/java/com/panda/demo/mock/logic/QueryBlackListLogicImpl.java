package com.panda.demo.mock.logic;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 查询黑名单列表
 * @author w
 * @date 2020-07-21
 */
@Slf4j
@Service
public class QueryBlackListLogicImpl implements LogicService {

    @Override
    public String execute(JSONObject reqData) throws Exception {
        // 请求数据
        JSONObject body = reqData.getJSONObject("ReqBody");
        // 身份证号码
        String idCardNumber = body.getString("ZHJHAO");

        // 读取mock数据
        String mockFile = System.getProperty("user.dir") + "/mock/longjiang/blacklist/" + idCardNumber + ".json";
        log.debug("读取mock文件数据:{}",mockFile);
        File file = new File(mockFile);
        if(!file.exists()){
            return "{}";
        }

        List<String> data = Files.readAllLines(Paths.get(mockFile), StandardCharsets.UTF_8);
        String mockData =  String.join("",data);
        log.debug("返回MOCK数据:{}",mockData);

        return mockData;
    }
}

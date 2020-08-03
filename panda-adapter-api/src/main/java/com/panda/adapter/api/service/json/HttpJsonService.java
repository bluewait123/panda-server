package com.panda.adapter.api.service.json;

import com.google.gson.Gson;
import com.panda.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * HTTP JSON 接口请求
 * @author w
 * @date 2020-07-21
 */
@Slf4j
@Service
public class HttpJsonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Gson gson;

    /**
     * HTTP请求
     * @param url 请求API URL
     * @param request 请求信息
     * @param responseClass 响应数据对象
     */
    public <T> T request(String url, String request, Class<T> responseClass){
        return request(url, null, request,responseClass);
    }

    /**
     * HTTP请求
     * @param url 请求API URL
     * @param request 请求信息
     * @param responseClass 响应数据对象
     */
    public <T> T request(String url, Object request, Class<T> responseClass){
        return request(url, null, gson.toJson(request),responseClass);
    }

    /**
     * HTTP请求
     * @param url 请求API URL
     * @param header 报文头参数
     * @param request 请求数据对象
     * @param responseClass 响应数据对象
     */
    public <T> T request(String url, HashMap<String,String> header, Object request, Class<T> responseClass){
        return request(url, header, gson.toJson(request),responseClass);
    }

    /**
     * HTTP请求
     * @param url 请求API URL
     * @param header 报文头参数
     * @param requestJson 请求信息
     * @param responseClass 响应数据对象
     */
    public <T> T request(String url, HashMap<String,String> header, String requestJson, Class<T> responseClass){

        // 报文头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=utf-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        if(null != header && header.size() > 0){
            for(String key : header.keySet()){
                headers.add(key,header.get(key));
            }
        }

        HttpEntity<String> formEntity = new HttpEntity<>(requestJson,headers);
        ResponseEntity<String> entity = restTemplate.postForEntity(url,formEntity,String.class);
        String response = null == entity ? null : entity.getBody();
        return StringUtils.isEmpty(response) ? null : gson.fromJson(response,responseClass);
    }

}

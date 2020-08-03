package com.panda.boss.adapter;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.panda.boss.adapter.file.FileReq;
import com.panda.boss.adapter.file.FileResp;
import com.panda.boss.enums.FileSystemTranCodeEnum;
import com.panda.boss.enums.NoteErrorEnum;
import com.panda.boss.exception.NoteException;
import com.panda.common.enums.BossErrorEnum;
import com.panda.common.exception.BossException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 文件系统适配器
 * @author w
 * @date 2020-07-08
 */
@Slf4j
@Service
public class FileSystemAdapter {
    private static final String SUCCESS_CODE = "0000";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${request.http.file.intranet}")
    private String url;

    @Resource(name = "fileSystemHttpHeaders")
    private HttpHeaders fileSystemHttpHeaders;

    @Autowired
    private Gson gson;

    /**
     * 请求数据
     * @param tranCodeEnum 交易码
     * @param req 请求信息
     * @param responseClass 接收响应信息类
     */
    public <T extends FileResp> T request(FileSystemTranCodeEnum tranCodeEnum, FileReq req, Class<T> responseClass){
        log.debug("请求文件系统参数:{}",null == req ? null : JSONObject.toJSONString(req));
        HttpEntity<FileReq> formEntity = new HttpEntity<>(req,fileSystemHttpHeaders);
        try{
            ResponseEntity<String> entity = restTemplate.postForEntity(url + tranCodeEnum.getTranCode(),formEntity,String.class);
            T response = gson.fromJson(entity.getBody(),responseClass);
            log.debug("文件系统响应结果:{}",null == response ? null : JSONObject.toJSONString(response));
            if(null == response || !SUCCESS_CODE.equals(response.getCode())){
                String msg = null == response ? "" : response.getMsg();
                throw new NoteException(NoteErrorEnum.FILE_SYSTEM_HANDLE_ERROR,msg);
            }
            return response;
        }catch (Exception e){
            throw new BossException(e,BossErrorEnum.FAIL);
        }
    }
}

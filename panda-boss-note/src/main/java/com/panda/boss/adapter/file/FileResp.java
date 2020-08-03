package com.panda.boss.adapter.file;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 文件系统响应 通用参数
 * @author w
 * @date 2020-07-08
 */
@Component
@Scope("prototype")
@Primary
@Data
public class FileResp implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;
}

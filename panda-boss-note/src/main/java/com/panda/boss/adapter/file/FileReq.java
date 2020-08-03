package com.panda.boss.adapter.file;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 请求文件系统 通用参数
 * @author w
 * @date 2020-07-08
 */
@Component
@Scope("prototype")
@Primary
@Data
public class FileReq implements Serializable {
    private static final long serialVersionUID = 1L;

}

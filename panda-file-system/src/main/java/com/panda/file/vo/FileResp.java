package com.panda.file.vo;

import com.panda.common.vo.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FileResp extends Response {
    /**
     * 文件系统
     */
    private String system = "FILE";

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;
}

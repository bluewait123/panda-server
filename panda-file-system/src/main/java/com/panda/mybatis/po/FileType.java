package com.panda.mybatis.po;

import java.util.Date;

public class FileType {
    private String id;

    private Date createTime;

    private String typeName;

    private Integer status;

    public FileType(String id, Date createTime, String typeName, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.typeName = typeName;
        this.status = status;
    }

    public FileType() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
package com.panda.mybatis.po;

import java.util.Date;

public class SystemRole {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String roleName;

    private Integer status;

    public SystemRole(String id, Date createTime, Date updateTime, String roleName, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.roleName = roleName;
        this.status = status;
    }

    public SystemRole() {
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
package com.panda.mybatis.po;

import java.util.Date;

public class SystemParam {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String paraCode;

    private String paraValue;

    private String remark;

    public SystemParam(Integer id, Date createTime, Date updateTime, String paraCode, String paraValue, String remark) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.paraCode = paraCode;
        this.paraValue = paraValue;
        this.remark = remark;
    }

    public SystemParam() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getParaCode() {
        return paraCode;
    }

    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
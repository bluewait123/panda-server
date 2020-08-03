package com.panda.mybatis.po;

import java.util.Date;

public class SysUser {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String userName;

    private String userPassword;

    private String passwordSalt;

    private String nickName;

    private String mobile;

    private String imageUrl;

    private String imageId;

    private Integer adminFlag;

    private Integer status;

    public SysUser(String id, Date createTime, Date updateTime, String userName, String userPassword, String passwordSalt, String nickName, String mobile, String imageUrl, String imageId, Integer adminFlag, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userName = userName;
        this.userPassword = userPassword;
        this.passwordSalt = passwordSalt;
        this.nickName = nickName;
        this.mobile = mobile;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.adminFlag = adminFlag;
        this.status = status;
    }

    public SysUser() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Integer getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Integer adminFlag) {
        this.adminFlag = adminFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
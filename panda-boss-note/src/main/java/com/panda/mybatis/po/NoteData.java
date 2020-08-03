package com.panda.mybatis.po;

import java.util.Date;

public class NoteData {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String userId;

    private String noteType;

    private String title;

    private String tags;

    private String fileId;

    private String fileUrl;

    private String screenImageId;

    private String screenImageUrl;

    private Integer publicType;

    private String accessPwd;

    private Integer status;

    private String data;

    public NoteData(Integer id, Date createTime, Date updateTime, String userId, String noteType, String title, String tags, String fileId, String fileUrl, String screenImageId, String screenImageUrl, Integer publicType, String accessPwd, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.noteType = noteType;
        this.title = title;
        this.tags = tags;
        this.fileId = fileId;
        this.fileUrl = fileUrl;
        this.screenImageId = screenImageId;
        this.screenImageUrl = screenImageUrl;
        this.publicType = publicType;
        this.accessPwd = accessPwd;
        this.status = status;
    }

    public NoteData(Integer id, Date createTime, Date updateTime, String userId, String noteType, String title, String tags, String fileId, String fileUrl, String screenImageId, String screenImageUrl, Integer publicType, String accessPwd, Integer status, String data) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.noteType = noteType;
        this.title = title;
        this.tags = tags;
        this.fileId = fileId;
        this.fileUrl = fileUrl;
        this.screenImageId = screenImageId;
        this.screenImageUrl = screenImageUrl;
        this.publicType = publicType;
        this.accessPwd = accessPwd;
        this.status = status;
        this.data = data;
    }

    public NoteData() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getScreenImageId() {
        return screenImageId;
    }

    public void setScreenImageId(String screenImageId) {
        this.screenImageId = screenImageId;
    }

    public String getScreenImageUrl() {
        return screenImageUrl;
    }

    public void setScreenImageUrl(String screenImageUrl) {
        this.screenImageUrl = screenImageUrl;
    }

    public Integer getPublicType() {
        return publicType;
    }

    public void setPublicType(Integer publicType) {
        this.publicType = publicType;
    }

    public String getAccessPwd() {
        return accessPwd;
    }

    public void setAccessPwd(String accessPwd) {
        this.accessPwd = accessPwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
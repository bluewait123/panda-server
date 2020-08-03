package com.panda.mybatis.po;

import java.util.Date;

public class FileAny {
    private String id;

    private Date createTime;

    private String fileType;

    private String fileName;

    private String filePath;

    private String fileUrl;

    private Integer status;

    public FileAny(String id, Date createTime, String fileType, String fileName, String filePath, String fileUrl, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.fileType = fileType;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileUrl = fileUrl;
        this.status = status;
    }

    public FileAny() {
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
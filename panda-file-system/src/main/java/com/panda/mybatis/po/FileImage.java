package com.panda.mybatis.po;

import java.util.Date;

public class FileImage {
    private String id;

    private Date createTime;

    private String fileName;

    private String filePath;

    private String fileUrlPath;

    private String bigPic;

    private String middlePic;

    private String smallPic;

    private Integer status;

    public FileImage(String id, Date createTime, String fileName, String filePath, String fileUrlPath, String bigPic, String middlePic, String smallPic, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileUrlPath = fileUrlPath;
        this.bigPic = bigPic;
        this.middlePic = middlePic;
        this.smallPic = smallPic;
        this.status = status;
    }

    public FileImage() {
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

    public String getFileUrlPath() {
        return fileUrlPath;
    }

    public void setFileUrlPath(String fileUrlPath) {
        this.fileUrlPath = fileUrlPath;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getMiddlePic() {
        return middlePic;
    }

    public void setMiddlePic(String middlePic) {
        this.middlePic = middlePic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
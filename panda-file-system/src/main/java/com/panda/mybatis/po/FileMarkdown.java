package com.panda.mybatis.po;

import java.util.Date;

public class FileMarkdown {
    private String id;

    private Date createTime;

    private String mdFileName;

    private String mdFilePath;

    private String mdFileUrl;

    private String htmlFileName;

    private String htmlFilePath;

    private String htmlFileUrl;

    private Integer status;

    public FileMarkdown(String id, Date createTime, String mdFileName, String mdFilePath, String mdFileUrl, String htmlFileName, String htmlFilePath, String htmlFileUrl, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.mdFileName = mdFileName;
        this.mdFilePath = mdFilePath;
        this.mdFileUrl = mdFileUrl;
        this.htmlFileName = htmlFileName;
        this.htmlFilePath = htmlFilePath;
        this.htmlFileUrl = htmlFileUrl;
        this.status = status;
    }

    public FileMarkdown() {
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

    public String getMdFileName() {
        return mdFileName;
    }

    public void setMdFileName(String mdFileName) {
        this.mdFileName = mdFileName;
    }

    public String getMdFilePath() {
        return mdFilePath;
    }

    public void setMdFilePath(String mdFilePath) {
        this.mdFilePath = mdFilePath;
    }

    public String getMdFileUrl() {
        return mdFileUrl;
    }

    public void setMdFileUrl(String mdFileUrl) {
        this.mdFileUrl = mdFileUrl;
    }

    public String getHtmlFileName() {
        return htmlFileName;
    }

    public void setHtmlFileName(String htmlFileName) {
        this.htmlFileName = htmlFileName;
    }

    public String getHtmlFilePath() {
        return htmlFilePath;
    }

    public void setHtmlFilePath(String htmlFilePath) {
        this.htmlFilePath = htmlFilePath;
    }

    public String getHtmlFileUrl() {
        return htmlFileUrl;
    }

    public void setHtmlFileUrl(String htmlFileUrl) {
        this.htmlFileUrl = htmlFileUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
package com.panda.mybatis.po;

import java.util.Date;

public class SysResource {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String parentId;

    private Integer menuType;

    private String menuName;

    private String menuIcon;

    private String routerUrl;

    private String authApi;

    private Integer soft;

    private Integer status;

    public SysResource(String id, Date createTime, Date updateTime, String parentId, Integer menuType, String menuName, String menuIcon, String routerUrl, String authApi, Integer soft, Integer status) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.parentId = parentId;
        this.menuType = menuType;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.routerUrl = routerUrl;
        this.authApi = authApi;
        this.soft = soft;
        this.status = status;
    }

    public SysResource() {
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getRouterUrl() {
        return routerUrl;
    }

    public void setRouterUrl(String routerUrl) {
        this.routerUrl = routerUrl;
    }

    public String getAuthApi() {
        return authApi;
    }

    public void setAuthApi(String authApi) {
        this.authApi = authApi;
    }

    public Integer getSoft() {
        return soft;
    }

    public void setSoft(Integer soft) {
        this.soft = soft;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
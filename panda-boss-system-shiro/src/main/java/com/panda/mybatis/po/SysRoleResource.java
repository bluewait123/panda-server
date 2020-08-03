package com.panda.mybatis.po;

public class SysRoleResource {
    private String resourceId;

    private String roleId;

    public SysRoleResource(String resourceId, String roleId) {
        this.resourceId = resourceId;
        this.roleId = roleId;
    }

    public SysRoleResource() {
        super();
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
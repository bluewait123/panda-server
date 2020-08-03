package com.panda.mybatis.po;

public class SystemRoleResource {
    private String resourceId;

    private String roleId;

    public SystemRoleResource(String resourceId, String roleId) {
        this.resourceId = resourceId;
        this.roleId = roleId;
    }

    public SystemRoleResource() {
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
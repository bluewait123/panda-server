package com.panda.mybatis.po;

public class SystemUserRole {
    private String userId;

    private String roleId;

    public SystemUserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public SystemUserRole() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
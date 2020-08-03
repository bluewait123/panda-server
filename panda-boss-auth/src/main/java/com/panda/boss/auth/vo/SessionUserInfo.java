package com.panda.boss.auth.vo;

import lombok.Data;

/**
 * 登录用户信息
 * @author wujianhui
 * @date 2020-07-01
 */
@Data
public class SessionUserInfo {
    /**
     * 用户ID
     */
    private String id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 管理员标志
     */
    private Integer adminFlag;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 状态
     */
    private Integer status;
}

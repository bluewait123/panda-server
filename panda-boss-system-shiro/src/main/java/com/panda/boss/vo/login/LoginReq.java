package com.panda.boss.vo.login;

import com.panda.common.vo.BossReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登录认证请求信息
 * @author w
 * @date 2020-06-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class LoginReq extends BossReq {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String pwd;
}

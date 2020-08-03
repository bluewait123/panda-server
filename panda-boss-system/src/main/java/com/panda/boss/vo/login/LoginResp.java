package com.panda.boss.vo.login;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登录认证响应信息
 * @author w
 * @date 2020-06-28
 */
@Data
public class LoginResp {

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 登录票据
     */
    private String token;
}

package com.panda.boss.vo.login;

import com.panda.common.vo.BossResp;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登录认证响应信息
 * @author w
 * @date 2020-06-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class LoginResp extends BossResp {

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 登录票据
     */
    private String token;
}

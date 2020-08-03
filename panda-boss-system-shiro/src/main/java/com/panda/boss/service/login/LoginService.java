package com.panda.boss.service.login;

import com.panda.boss.enums.SystemErrorEnum;
import com.panda.boss.exception.SystemException;
import com.panda.boss.vo.login.LoginReq;
import com.panda.boss.vo.login.LoginResp;
import com.panda.common.utils.PrimaryKeyUtils;
import com.panda.mybatis.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    /**
     * 用户登录认证
     * @param loginReq 登录信息
     * @return 认证结果
     */
    public LoginResp login(LoginReq loginReq){
        try{
            // 从SecurityUtils里边创建一个 subject
            Subject subject = SecurityUtils.getSubject();
            // 创建令牌
            UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getUserName(), loginReq.getPwd());
            subject.login(token);
            Session session = subject.getSession();
            SysUser sysUser = (SysUser)session.getAttribute("user");
            LoginResp resp = new LoginResp();
            resp.setNickName(sysUser.getNickName());
            resp.setToken(PrimaryKeyUtils.getUuid());
            return resp;
        }catch (AccountException e){
            throw new SystemException(e,SystemErrorEnum.AUTH_ERROR,e.getMessage());
        }
    }
}

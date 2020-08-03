package com.panda.boss.service.auth;

import com.panda.boss.enums.SystemErrorEnum;
import com.panda.boss.service.user.UserService;
import com.panda.common.utils.MD5Utils;
import com.panda.common.utils.SpringContextUtils;
import com.panda.mybatis.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Optional;

/**
 * shiro 登录认证处理
 * @author w
 * @date 2020-06-30
 */
@Slf4j
public class BossAuthorizingRealm extends AuthorizingRealm {

    /**
     * 查询授权资源
     * @param principalCollection 信息
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("doGetAuthorizationInfo!!!");
        return null;
    }

    /**
     * 安全认证
     * @param token 认证信息
     * @return 认证结果
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());

        // 通过Spring上下文获取
        UserService userService = SpringContextUtils.getBean(UserService.class);

        // 查询用户信息
        SysUser systemUser = userService.findByUserName(userName);
        Optional.ofNullable(systemUser).orElseThrow(() -> {
            log.error("{}用户不存在",userName);
            return new AccountException(SystemErrorEnum.USER_NOT_EXITS_OR_PWD_ERROR.getDesc());
        });

        String userPwd = MD5Utils.hmacMD5(password,systemUser.getPasswordSalt());
        String dbPwd = systemUser.getUserPassword();
        if(!userPwd.equals(dbPwd)){
            log.error("{}密码错误!", systemUser.getUserName());
            log.debug("user:{},db:{}",userPwd,dbPwd);
            throw new AccountException(SystemErrorEnum.USER_NOT_EXITS_OR_PWD_ERROR.getDesc());
        }

        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user",systemUser);
        session.setAttribute("userId",systemUser.getId());
        session.setAttribute("userName",systemUser.getUserName());

        // 用户，密码，字节，realm name
        return new SimpleAuthenticationInfo(userName, password, ByteSource.Util.bytes(userName), getName());
    }
}

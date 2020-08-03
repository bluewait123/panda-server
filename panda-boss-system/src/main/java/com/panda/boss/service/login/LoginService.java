package com.panda.boss.service.login;

import com.panda.boss.auth.constant.AuthRedisKey;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.boss.enums.SystemErrorEnum;
import com.panda.boss.enums.SystemParamKeyEnum;
import com.panda.boss.enums.UserStatusEnum;
import com.panda.boss.exception.SystemException;
import com.panda.boss.service.cache.CacheService;
import com.panda.boss.service.role.RoleService;
import com.panda.boss.service.user.UserService;
import com.panda.boss.vo.login.LoginResp;
import com.panda.common.redis.service.RedisService;
import com.panda.common.utils.MD5Utils;
import com.panda.common.utils.PrimaryKeyUtils;
import com.panda.common.utils.StringUtils;
import com.panda.mybatis.po.SystemParam;
import com.panda.mybatis.po.SystemResource;
import com.panda.mybatis.po.SystemUser;
import com.panda.mybatis.po.SystemUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 登录认证服务
 * @author w
 * @date 2020-06-28
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private CacheService cacheService;

    /**
     * 登录验证
     * @param userName 用户名
     * @param pwd 密码
     * @return LoginResp
     */
    public LoginResp login(String userName, String pwd){
        // 获取用户信息
        SystemUser systemUser = userService.findByUserName(userName);
        Optional.ofNullable(systemUser).orElseThrow(() -> {
            log.error("{}用户不存在",userName);
            return new SystemException(SystemErrorEnum.USER_NOT_EXITS_OR_PWD_ERROR);
        });

        // 检查登录密码
        checkLoginPwd(systemUser,pwd);

        // 检查用户状态
        checkUserStatus(systemUser);

        // 登录有效期
        SystemParam authTimeOut = cacheService.getSystemParameter(SystemParamKeyEnum.LOGIN_AUTH_TIME_OUT.getCode());
        if(StringUtils.isNotEmpty(authTimeOut)){
            redisService.set(AuthRedisKey.getUserAuthTimeOutKey(systemUser.getId()),authTimeOut.getParaValue());
        }

        // 缓存用户信息
        String token = PrimaryKeyUtils.getUuid();
        SessionUserInfo sessionUserInfo = concatCacheUserInfo(systemUser);
        redisService.putObject(AuthRedisKey.getSessionUserInfoKey(token),sessionUserInfo);

        // 缓存权限信息
        List<String> urls = getAuthUrl(sessionUserInfo.getRoleId());
        redisService.putObject(AuthRedisKey.getUserAuthResourceKey(systemUser.getId()),urls);

        // 响应前端结果
        LoginResp response = new LoginResp();
        response.setToken(token);
        response.setNickName(systemUser.getNickName());
        return response;
    }

    /**
     * 检查登录密码
     * @param systemUser 用户信息
     * @param userPwd 前端输入的密码
     */
    private void checkLoginPwd(SystemUser systemUser, String userPwd){
        userPwd = MD5Utils.hmacMD5(userPwd,systemUser.getPasswordSalt());
        String dbPwd = systemUser.getUserPassword();
        if(!userPwd.equals(dbPwd)){
            log.error("{}密码错误!", systemUser.getUserName());
            log.debug("user:{},db:{}",userPwd,dbPwd);
            throw new SystemException(SystemErrorEnum.USER_NOT_EXITS_OR_PWD_ERROR);
        }
    }

    /**
     * 检查用户状态
     * @param systemUser 用户信息
     */
    private void checkUserStatus(SystemUser systemUser){
        // 检查状态
        switch (UserStatusEnum.getEnumByCode(systemUser.getStatus())){
            case ENABLE:
                break;
            case LOCK:
                throw new SystemException(SystemErrorEnum.USER_STATUS_LOCK_ERROR);
            case DISABLE:
                throw new SystemException(SystemErrorEnum.USER_STATUS_DISABLE_ERROR);
            default:
                throw new SystemException(SystemErrorEnum.USER_STATUS_UNKNOWN_ERROR);
        }
    }

    /**
     * 组装缓存用户信息
     * @param systemUser 用户信息
     * @return SessionUserInfo
     */
    private SessionUserInfo concatCacheUserInfo(SystemUser systemUser){
        SessionUserInfo userInfo = new SessionUserInfo();
        userInfo.setId(systemUser.getId());
        userInfo.setMobile(systemUser.getMobile());
        userInfo.setNickName(systemUser.getNickName());
        userInfo.setAdminFlag(systemUser.getAdminFlag());
        userInfo.setStatus(systemUser.getStatus());

        // 获取用户角色ID
        SystemUserRole role = roleService.findUserRoleByUserId(systemUser.getId());
        userInfo.setRoleId(role.getRoleId());
        return userInfo;
    }

    /**
     * 根据角色ID获取授权资源
     * @param roleId 角色ID
     * @return List<String>
     */
    private List<String> getAuthUrl(String roleId){
        List<SystemResource> list = cacheService.getSystemResource(roleId);
        List<String> urls = new ArrayList<>();
        if(StringUtils.isNotEmpty(list)){
            for(SystemResource resource : list){
                String url = resource.getAuthApi();
                if(StringUtils.isNotEmpty(url)){
                    urls.addAll(Arrays.asList(url.split(",")));
                }
            }
        }
        return urls;
    }
}

package com.panda.boss.service.user;

import com.panda.mybatis.mapper.SystemUserMapper;
import com.panda.mybatis.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息管理
 * @author w
 * @date 2020-06-28
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    /**
     * 根据用户名获取用户信息
     * @param userName 用户名
     * @return SystemUser
     */
    public SysUser findByUserName(String userName){
        return systemUserMapper.selectByUserName(userName);
    }
}

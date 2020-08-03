package com.panda.boss.service.role;

import com.panda.boss.enums.SystemErrorEnum;
import com.panda.boss.exception.SystemException;
import com.panda.mybatis.mapper.SystemUserRoleMapper;
import com.panda.mybatis.po.SystemUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 角色信息管理
 * @author w
 * @date 2020-07-01
 */
@Slf4j
@Service
public class RoleService {
    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    public SystemUserRole findUserRoleByUserId(String userId){
        SystemUserRole role = systemUserRoleMapper.selectByUserId(userId);
        Optional.ofNullable(role).orElseThrow(() -> new SystemException(SystemErrorEnum.ROLE_NOT_EXITS_ERROR));
        return role;
    }

}

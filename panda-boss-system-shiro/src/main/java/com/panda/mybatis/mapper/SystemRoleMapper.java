package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SysRole;

public interface SystemRoleMapper {

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

}
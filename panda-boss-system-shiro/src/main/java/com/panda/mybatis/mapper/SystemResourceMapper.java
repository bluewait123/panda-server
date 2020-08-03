package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SysResource;

public interface SystemResourceMapper {
    int updateByPrimaryKeySelective(SysResource record);
}
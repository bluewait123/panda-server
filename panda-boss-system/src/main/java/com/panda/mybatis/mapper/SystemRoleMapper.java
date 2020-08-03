package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SystemRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色信息管理
 * @author w
 * @date 2020-07-01
 */
@Component
public interface SystemRoleMapper {

    /**
     * 根据主键查询角色信息
     * @param id 主键
     * @return SystemRole
     */
    SystemRole selectByPrimaryKey(String id);

    /**
     * 查询所有角色信息
     * @return List<SystemRole>
     */
    List<SystemRole> selectAll();

    /**
     * 新增角色信息
     * @param record 角色信息
     * @return 受影响行数
     */
    int insertSelective(SystemRole record);

    /**
     * 更新角色信息
     * @param record 角色信息
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(SystemRole record);

}
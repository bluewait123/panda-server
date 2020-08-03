package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SystemResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 * 菜单资源管理
 * @author w
 * @date 2020-07-01
 */
@Component
public interface SystemResourceMapper {

    /**
     * 根据角色ID获取权限信息
     * @param roleId 角色ID
     * @return List<SystemResource>
     */
    List<SystemResource> selectByRoleId(@Param("roleId") String roleId);

    /**
     * 更新菜单信息
     * @param record 菜单记录
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(SystemResource record);
}
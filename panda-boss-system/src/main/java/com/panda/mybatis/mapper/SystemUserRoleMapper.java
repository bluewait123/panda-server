package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SystemUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SystemUserRoleMapper {

    /**
     * 新增用户角色关联信息
     * @param record 记录
     * @return 受影响行数
     */
    int insertSelective(SystemUserRole record);

    /**
     * 根据用户ID获取角色ID
     * @param userId 用户ID
     * @return SystemUserRole
     */
    SystemUserRole selectByUserId(@Param("userId") String userId);
}
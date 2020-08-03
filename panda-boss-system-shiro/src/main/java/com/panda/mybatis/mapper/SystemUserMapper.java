package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 用户信息数据操作
 * @author w
 * @date 2020-06-28
 */
@Component
public interface SystemUserMapper {

    /**
     * 新增用户信息
     * @param record 用户信息记录
     * @return 受影响行数 INT
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键更新用户信息
     * @param record 待用户信息记录
     * @return 受影响行数 INT
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据主键查询用户信息
     * @param id 用户ID
     * @return 用户信息 SystemUser
     */
    SysUser selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 用户信息 SystemUser
     */
    SysUser selectByUserName(@Param("userName") String userName);
}
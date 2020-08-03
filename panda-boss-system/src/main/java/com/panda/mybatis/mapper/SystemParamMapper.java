package com.panda.mybatis.mapper;

import com.panda.mybatis.po.SystemParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SystemParamMapper {

    /**
     * 根据主键获取系统参数信息
     * @param id 主键
     * @return SystemParam
     */
    SystemParam selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 根据主键获取系统参数信息
     * @param paraCode 主键
     * @return SystemParam
     */
    SystemParam selectByParaCode(@Param("paraCode") String paraCode);

    /**
     * 获取所有系统参数
     * @return List<SystemParam>
     */
    List<SystemParam> selectAll();

    /**
     * 根据主键更新系统参数
     * @param record 更新信息
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(SystemParam record);
}
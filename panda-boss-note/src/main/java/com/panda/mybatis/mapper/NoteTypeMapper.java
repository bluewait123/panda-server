package com.panda.mybatis.mapper;

import com.panda.mybatis.po.NoteType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoteTypeMapper {

    /**
     * 根据主键获取笔记种类信息
     * @param id 主键
     * @return NoteType
     */
    NoteType selectByPrimaryKey(String id);

    /**
     * 根据用户ID查询笔记信息
     * @param userId 用户ID
     * @return List<NoteType>
     */
    List<NoteType> selectByUserId(@Param("userId") String userId);

    /**
     * 新增笔记种类信息
     * @param record 新增信息
     * @return 受影响行数
     */
    int insertSelective(NoteType record);

    /**
     * 更新笔记种类信息
     * @param record 笔记信息
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(NoteType record);

    /**
     * 查询指定对笔记类型
     * @param ids 笔记类型ID集
     */
    List<NoteType> selectByIds(@Param("ids") List<String> ids);
}
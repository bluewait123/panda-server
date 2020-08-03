package com.panda.mybatis.mapper;

import com.panda.boss.vo.note.MultipleQueryNoteDataReq;
import com.panda.boss.vo.note.QueryNoteDataByNoteTypeReq;
import com.panda.boss.vo.note.item.MultipleQueryNoteDataItem;
import com.panda.boss.vo.note.item.SimpleQueryNoteDataItem;
import com.panda.mybatis.po.NoteData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoteDataMapper {

    /**
     * 新增笔记信息
     * @param record 笔记信息
     * @return 受影响行数
     */
    int insertSelective(NoteData record);

    /**
     * 根据主键更新笔记信息
     * @param record 笔记信息
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(NoteData record);

    /**
     * 根据笔记主键查询笔记信息
     * @param id 主键
     * @return NoteData
     */
    NoteData selectByPrimaryKey(Integer id);

    /**
     * 根据用户ID查询笔记信息
     * @param userId 用户ID
     * @return List<QueryNoteDataItem>
     */
    List<SimpleQueryNoteDataItem> selectByUserId(@Param("userId") String userId);


    /**
     * 根据请求条件查询笔记信息
     * @param req 请求条件
     * @param userId 用户ID
     * @return List<QueryNoteDataItem>
     */
    List<MultipleQueryNoteDataItem> selectByTitle(@Param("req") MultipleQueryNoteDataReq req, @Param("userId") String userId);

    /**
     * 获取指定类型下所有笔记信息
     * @param req 请求信息
     * @param userId 用户ID
     * @return List<MultipleQueryNoteDataItem>
     */
    List<MultipleQueryNoteDataItem> selectByNoteType(@Param("req") QueryNoteDataByNoteTypeReq req, @Param("userId") String userId);

    /**
     * 根据用户ID获取笔记标签信息
     * @param userId 用户ID
     * @return String
     */
    String selectTagsByUserId(@Param("userId") String userId);
}
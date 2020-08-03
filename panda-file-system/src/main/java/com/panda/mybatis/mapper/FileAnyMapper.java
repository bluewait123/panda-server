package com.panda.mybatis.mapper;

import com.panda.mybatis.po.FileAny;

public interface FileAnyMapper {
    int deleteByPrimaryKey(String id);

    int insert(FileAny record);

    int insertSelective(FileAny record);

    FileAny selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FileAny record);

    int updateByPrimaryKey(FileAny record);
}
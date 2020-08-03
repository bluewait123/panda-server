package com.panda.mybatis.mapper;

import com.panda.mybatis.po.FileType;

public interface FileTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(FileType record);

    int insertSelective(FileType record);

    FileType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FileType record);

    int updateByPrimaryKey(FileType record);
}
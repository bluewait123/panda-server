package com.panda.mybatis.mapper;

import com.panda.mybatis.po.FileImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文件信息管理
 * @author w
 * @date 2020-07-08
 */
@Component
public interface FileImageMapper {
    /**
     * 根据主键删除文件信息
     * @param id 主键
     * @return 受影响行数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增图片文件信息
     * @param record 图片文件信息
     * @return 受影响行数
     */
    int insertSelective(FileImage record);

    /**
     * 根据主键更新文件信息
     * @param record 图片文件信息
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(FileImage record);

    /**
     * 根据主键获取图片文件信息
     * @param id 主键
     * @return FileImage
     */
    FileImage selectByPrimaryKey(String id);

    /**
     * 根据主键获取图片文件信息
     * @param ids 主键
     * @return FileImage
     */
    List<FileImage> selectByPrimaryKeys(@Param("ids") String[] ids);
}
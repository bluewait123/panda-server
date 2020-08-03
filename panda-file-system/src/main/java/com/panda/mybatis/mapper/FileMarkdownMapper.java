package com.panda.mybatis.mapper;

import com.panda.mybatis.po.FileMarkdown;
import org.springframework.stereotype.Component;

/**
 * markdown文件信息管理
 * @author w
 * @date 2020-07-08
 */
@Component
public interface FileMarkdownMapper {

    /**
     * 新增markdown文件信息
     * @param record markdown信息
     * @return 受影响行数
     */
    int insertSelective(FileMarkdown record);

    /**
     * 更新markdown文件信息
     * @param record markdown文件信息
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(FileMarkdown record);

    /**
     * 根据主键获取markdown文件信息
     * @param id 主键
     * @return FileMarkdown
     */
    FileMarkdown selectByPrimaryKey(String id);
}
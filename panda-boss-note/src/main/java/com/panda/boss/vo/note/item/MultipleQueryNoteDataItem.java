package com.panda.boss.vo.note.item;

import lombok.Data;

/**
 * 高级查询笔记信息
 * @author w
 * @date 2020-07-10
 */
@Data
public class MultipleQueryNoteDataItem {

    /**
     * 主键
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private String tags;

    /**
     * 数据
     */
    private String data;

    /**
     * 创建日期
     */
    private String createTime;

    /**
     * 笔记类型路径
     */
    private String noteTypePathsId;

    /**
     * 笔记类型路径名称
     */
    private String noteTypePathsName;

    /**
     * 截图访问链接
     */
    private String screenImageUrl;
}

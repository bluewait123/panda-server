package com.panda.boss.vo.note.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 查询笔记信息列表信息
 * @author w
 * @date 2020-07-06
 */
@Data
public class SimpleQueryNoteDataItem {

    /**
     * 笔记ID
     */
    private String id;

    /**
     * 创建日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private LocalDateTime createTime;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 笔记类型名称
     */
    private String typeName;

    /**
     * 笔记标签
     */
    private String tags;
}

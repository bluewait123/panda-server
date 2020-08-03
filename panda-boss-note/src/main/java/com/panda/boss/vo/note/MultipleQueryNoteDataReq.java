package com.panda.boss.vo.note;

import com.panda.common.vo.BossPageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 高级查询笔记信息
 * @author w
 * @date 2020-07-06
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class MultipleQueryNoteDataReq extends BossPageReq {

    /**
     * 搜索内容
     */
    private String keyword;

    /**
     * 标签
     */
    private String[] tags;
}

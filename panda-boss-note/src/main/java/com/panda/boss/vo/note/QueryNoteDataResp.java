package com.panda.boss.vo.note;

import com.panda.boss.vo.note.item.SimpleQueryNoteDataItem;
import com.panda.common.vo.BossPageResp;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 * 高级查询笔记信息
 * @author w
 * @date 2020-07-06
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class QueryNoteDataResp extends BossPageResp {

    /**
     * 笔记信息集
     */
    private List<SimpleQueryNoteDataItem> list;
}

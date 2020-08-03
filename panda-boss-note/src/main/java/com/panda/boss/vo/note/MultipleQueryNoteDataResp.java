package com.panda.boss.vo.note;

import com.panda.boss.vo.note.item.MultipleQueryNoteDataItem;
import com.panda.common.vo.BossPageReq;
import com.panda.mybatis.po.NoteType;
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
public class MultipleQueryNoteDataResp extends BossPageReq {

    /**
     * 笔记信息
     */
    private List<MultipleQueryNoteDataItem> list;

    /**
     * 笔记类型
     */
    private List<NoteType> types;
}

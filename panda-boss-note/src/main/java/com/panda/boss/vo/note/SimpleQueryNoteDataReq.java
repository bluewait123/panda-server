package com.panda.boss.vo.note;

import com.panda.common.vo.BossPageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 * 查询笔记信息
 * @author w
 * @date 2020-07-06
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class SimpleQueryNoteDataReq extends BossPageReq {

    /**
     * 笔记类型
     */
    private List<String> type;

    /**
     * 笔记状态
     */
    private Integer status;

}

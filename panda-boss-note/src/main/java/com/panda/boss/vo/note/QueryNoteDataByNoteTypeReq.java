package com.panda.boss.vo.note;

import com.panda.common.vo.BossPageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 获取指定类型下所有笔记信息
 * @author w
 * @date 2020-07-06
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class QueryNoteDataByNoteTypeReq extends BossPageReq {

    /**
     * 笔记类型
     */
    private String noteType;
}

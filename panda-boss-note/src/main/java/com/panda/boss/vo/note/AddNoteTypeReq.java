package com.panda.boss.vo.note;

import com.panda.common.vo.BossReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新增笔记种类
 * @author w
 * @date 2020-07-06
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class AddNoteTypeReq extends BossReq {

    /**
     * 种类名称
     */
    private String typeName;

    /**
     * 上级ID
     */
    private String parentId;
}

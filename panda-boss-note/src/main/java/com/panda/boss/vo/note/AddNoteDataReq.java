package com.panda.boss.vo.note;

import com.panda.common.vo.BossReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新增笔记信息
 * @author w
 * @date 2020-07-06
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class AddNoteDataReq extends BossReq {

    /**
     * 笔记类型
     */
    private String noteType;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private String tags;

    /**
     * 笔记文本信息
     */
    private String data;

    /**
     * 笔记截图ID
     */
    private String screenImageId;
}

package com.panda.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页信息
 * @author w
 * @date 2020-06-28
 */
@Data
public class PandaPageInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前分页页码
     */
    private int pageNum;

    /**
     * 分页数量
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private long totalCount;

    /**
     * 总记录数
     */
    private long pageCount;
}

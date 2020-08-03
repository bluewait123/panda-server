package com.panda.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BOSS 分页响应公共信息
 * @author w
 * @date 2020-06-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BossPageResp extends BossResp {

    /**
     * 分页信息
     */
    private PandaPageInfo page;

    /**
     * 设置分页信息
     * @param pageInfo 分页信息
     */
    @JsonIgnore
    public void setPaging(PageInfo<?> pageInfo) {
        if (null != pageInfo) {
            PandaPageInfo page = new PandaPageInfo();
            page.setPageNum(0 == pageInfo.getPageNum() ? 1 : pageInfo.getPageNum());
            page.setPageSize(pageInfo.getPageSize());
            page.setTotalCount(pageInfo.getTotal());
            page.setPageCount(pageInfo.getPages());
        }
    }
}

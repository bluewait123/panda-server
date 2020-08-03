package com.panda.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BOSS 分页请求公共信息
 * @author w
 * @date 2020-06-28
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BossPageReq extends BossReq {
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 条数
     */
    private Integer pageSize = 10;

    /**
     * 设置分页信息
     */
    @JsonIgnore
    public void setPaging(){
        PageHelper.startPage(this.getPageNum(), this.getPageSize(),this.getPageNum() == 1);
    }
}

package com.panda.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class BasicService {

    /**
     * 获取分页信息
     * @param list 查询数据
     * @return PageInfo<?>
     */
    public <T> PageInfo<T> getPageInfo(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        PageHelper.clearPage();
        return pageInfo;
    }
}

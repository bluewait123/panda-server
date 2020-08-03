package com.panda.boss.vo.common;

import lombok.Data;


/**
 * 用户菜单信息
 * @author w
 * @date 2020-07-01
 */
@Data
public class UserMenuItem{
    private String id;
    private String parentId;
    private String name;
    private String icon;
    private String routerUrl;
    private Integer menuType;
}

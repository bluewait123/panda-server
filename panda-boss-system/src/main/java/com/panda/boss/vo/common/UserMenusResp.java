package com.panda.boss.vo.common;

import lombok.Data;

import java.util.List;


/**
 * 用户菜单响应信息
 * @author w
 * @date 2020-07-01
 */
@Data
public class UserMenusResp {
    private List<UserMenuItem> list;
    private List<String> buttons;
}

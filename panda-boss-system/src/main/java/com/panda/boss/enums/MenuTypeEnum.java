package com.panda.boss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单类型枚举
 * @author w
 * @date 2020-06-30
 */
@AllArgsConstructor
@Getter
public enum MenuTypeEnum {
    /**
     * 定义
     */
    MENU(1,"菜单"),
    BUTTON(2,"按钮"),

    ;

    private Integer code;
    private String desc;

    public static MenuTypeEnum getEnumByCode(Integer code){
        MenuTypeEnum e = null;
        for(MenuTypeEnum status : values()){
            if(status.getCode().equals(code)){
                e = status;
                break;
            }
        }
        return e;
    }
}

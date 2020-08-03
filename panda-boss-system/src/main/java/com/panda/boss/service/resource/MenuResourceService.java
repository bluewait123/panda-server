package com.panda.boss.service.resource;

import com.panda.boss.enums.MenuTypeEnum;
import com.panda.boss.service.cache.CacheService;
import com.panda.boss.vo.common.UserMenuItem;
import com.panda.boss.vo.common.UserMenusResp;
import com.panda.common.utils.StringUtils;
import com.panda.mybatis.mapper.SystemResourceMapper;
import com.panda.mybatis.po.SystemResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单资源管理
 * @author w
 * @date 2020-07-01
 */
@Slf4j
@Service
public class MenuResourceService {
    @Autowired
    private SystemResourceMapper systemResourceMapper;

    @Autowired
    private CacheService cacheService;

    /**
     * 查询用户菜单资源
     * @param roleId 角色ID
     * @return UserMenusResp
     */
    public UserMenusResp findUserResource(String roleId) {
        List<SystemResource> resources = cacheService.getSystemResource(roleId);
        UserMenusResp resp = new UserMenusResp();

        if (StringUtils.isNotEmpty(resources) && resources.size() > 0) {
            List<UserMenuItem> menus = new ArrayList<>();
            List<String> buttons = new ArrayList<>();

            UserMenuItem item;
            for (SystemResource resource : resources) {
                if(MenuTypeEnum.BUTTON.getCode().equals(resource.getMenuType())){
                    buttons.add(resource.getRouterUrl());
                }

                item = new UserMenuItem();
                item.setId(resource.getId());
                item.setName(resource.getMenuName());
                item.setIcon(resource.getMenuIcon());
                item.setParentId(resource.getParentId());
                item.setRouterUrl(resource.getRouterUrl());
                item.setMenuType(resource.getMenuType());
                menus.add(item);
            }
            resp.setList(menus);
            resp.setButtons(buttons);
        }
        return resp;
    }
}

package com.panda.boss.controller;

import com.panda.boss.auth.annotation.SessionUser;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.boss.service.resource.MenuResourceService;
import com.panda.common.controller.BasicController;
import com.panda.common.vo.BossResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共API
 * @author w
 * @date 2020-07-01
 */
@RequestMapping("/common")
@Slf4j
@RestController
public class CommonController extends BasicController {

    @Autowired
    private MenuResourceService menuResourceService;

    @GetMapping("/menus")
    @ResponseBody
    public BossResp getMenus(@SessionUser SessionUserInfo userInfo){
        return assemble(menuResourceService.findUserResource(userInfo.getRoleId()));
    }


}

package com.panda.boss.controller.login;

import com.panda.boss.service.login.LoginService;
import com.panda.common.controller.BasicController;
import com.panda.common.vo.BossResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录
 * @author w
 * @date 2020-06-23
 */
@RestController
@Slf4j
public class LoginController extends BasicController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    @ResponseBody
    public BossResp login(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd){
        return assemble(loginService.login(userName,pwd));
    }
}

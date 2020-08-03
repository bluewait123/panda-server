package com.panda.boss.controller.resource;

import com.panda.common.controller.BasicController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统资源
 * @author w
 * @date 2020-06-30
 */
@RequestMapping("/resource")
@RestController
@Slf4j
public class SysResourceController extends BasicController {

//    @RequestMapping(value = "/list", method = { RequestMethod.POST })
//    @ResponseBody
//    public BossResp list(){
//        log.debug("query resource list !!!");
//        return assemble(null );
//    }
}

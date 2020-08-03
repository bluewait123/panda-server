package com.panda.boss.controller.note;

import com.panda.boss.auth.annotation.SessionUser;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.boss.service.NoteTypeService;
import com.panda.boss.vo.note.AddNoteTypeReq;
import com.panda.common.controller.BasicController;
import com.panda.common.vo.BossResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 笔记种类配置
 * @author w
 * @date 2020-07-06
 */
@RequestMapping("/notepad/type")
@Slf4j
@RestController
public class NoteTypeController extends BasicController {

    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("/list")
    @ResponseBody
    public BossResp list(@SessionUser SessionUserInfo userInfo){
        return assemble(noteTypeService.findAll(userInfo.getId()));
    }

    @PostMapping("/add")
    @ResponseBody
    public BossResp add(@RequestBody AddNoteTypeReq req, @SessionUser SessionUserInfo userInfo){
        return assemble(noteTypeService.add(req,userInfo));
    }
}

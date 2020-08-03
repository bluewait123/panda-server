package com.panda.boss.controller.note;

import com.panda.boss.auth.annotation.SessionUser;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.boss.service.NoteDataService;
import com.panda.boss.vo.note.AddNoteDataReq;
import com.panda.boss.vo.note.MultipleQueryNoteDataReq;
import com.panda.boss.vo.note.QueryNoteDataByNoteTypeReq;
import com.panda.boss.vo.note.SimpleQueryNoteDataReq;
import com.panda.common.controller.BasicController;
import com.panda.common.vo.BossResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 笔记信息管理
 * @author w
 * @date 2020-07-06
 */
@RequestMapping("/notepad/data")
@Slf4j
@RestController
public class NoteDataController extends BasicController {

    @Autowired
    private NoteDataService noteDataService;

    /**
     * 列表查询
     * @param req 请求信息
     * @param userInfo 用户信息
     */
    @PostMapping("/simpleQuery")
    @ResponseBody
    public BossResp simpleQuery(@RequestBody SimpleQueryNoteDataReq req, @SessionUser SessionUserInfo userInfo){
        return assemble(noteDataService.simple(req,userInfo));
    }

    /**
     * 高级查询
     * @param req 请求信息
     * @param userInfo 用户信息
     */
    @PostMapping("/multipleQuery")
    @ResponseBody
    public BossResp multipleQuery(@RequestBody MultipleQueryNoteDataReq req, @SessionUser SessionUserInfo userInfo){
        return noteDataService.multiple(req,userInfo);
    }

    /**
     * 获取指定类型下所有笔记信息
     */
    @PostMapping("/queryByNoteType")
    @ResponseBody
    public BossResp queryByNoteType(@RequestBody QueryNoteDataByNoteTypeReq req, @SessionUser SessionUserInfo userInfo){
        return assemble(noteDataService.queryByNoteType(req,userInfo));
    }

    /**
     * 查看详情
     */
    @GetMapping("/detail")
    @ResponseBody
    public BossResp detail(@RequestParam("id") String id){
        return assemble(noteDataService.detail(id));
    }

    /**
     * 获取标签列表
     */
    @GetMapping("/tags")
    @ResponseBody
    public BossResp tags(@SessionUser SessionUserInfo userInfo){
        return assemble(noteDataService.queryTags(userInfo.getId()));
    }


    /**
     * 新增笔记信息
     * @param req 请求信息
     * @param userInfo 用户信息
     */
    @PostMapping("/add")
    @ResponseBody
    public BossResp add(@RequestBody AddNoteDataReq req, @SessionUser SessionUserInfo userInfo){
        noteDataService.add(req,userInfo);
        return assemble();
    }

}

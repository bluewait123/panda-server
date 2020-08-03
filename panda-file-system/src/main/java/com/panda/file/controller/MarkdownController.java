package com.panda.file.controller;

import com.panda.file.service.MarkdownService;
import com.panda.file.vo.FileResp;
import com.panda.file.vo.GenerateMarkdownReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * markdown处理
 * @author w
 * @date 2020-07-08
 */
@Slf4j
@RequestMapping("/md")
@RestController
public class MarkdownController extends BasicController{

    @Autowired
    private MarkdownService markdownService;

    /**
     * 生成markdown文件
     * @param req 请求信息
     */
    @PostMapping("/generate")
    @ResponseBody
    public FileResp generate(@RequestBody GenerateMarkdownReq req){
        return assemble(markdownService.generateFile(req));
    }
}

package com.panda.file.controller;

import com.panda.file.service.ImageService;
import com.panda.file.vo.FileResp;
import com.panda.file.vo.QueryImageFileReq;
import com.panda.file.vo.UploadImageStringReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片文件
 * @author w
 * @date 2020-07-08
 */
@Slf4j
@RequestMapping("/image")
@RestController
public class ImageController extends BasicController {

    @Autowired
    private ImageService imageService;

    /**
     * 上传图片文件
     * @param files 文件（可多个）
     */
    @PostMapping("/upload/file")
    @ResponseBody
    public FileResp uploadFile(@RequestParam(value = "files") MultipartFile[] files){
        return assemble();
    }

    /**
     * 上传图片文件(BASE64)
     * @param req 请求信息
     */
    @PostMapping("/upload/base64")
    @ResponseBody
    public FileResp uploadBase64(@RequestBody UploadImageStringReq req){
        return assemble(imageService.uploadImage(req));
    }

    @PostMapping("/details")
    @ResponseBody
    public FileResp query(@RequestBody QueryImageFileReq req){
        return assemble(imageService.getImageFileInfo(req.getIds()));
    }

}

package com.panda.file.service;

import com.panda.common.utils.DateUtils;
import com.panda.common.utils.PrimaryKeyUtils;
import com.panda.common.utils.StringUtils;
import com.panda.file.enums.FileErrorEnum;
import com.panda.file.enums.MarkdownFileStatusEnums;
import com.panda.file.exception.FileException;
import com.panda.file.utils.FileConfigUtils;
import com.panda.file.utils.FileUtils;
import com.panda.file.vo.GenerateMarkdownReq;
import com.panda.file.vo.GenerateMarkdownResp;
import com.panda.mybatis.mapper.FileMarkdownMapper;
import com.panda.mybatis.po.FileMarkdown;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * markdown 管理
 * @author w
 * @date 2020-07-08
 */
@Slf4j
@Service
public class MarkdownService {
    @Value("${markdown.template}")
    private String markdownTemplate;

    @Value("${markdown.replaceKey}")
    private String replaceKey;

    @Autowired
    private FileConfigUtils fileConfigUtils;

    @Autowired
    private FileMarkdownMapper fileMarkdownMapper;

    /**
     * 生成markdown文件
     * @param req 请求数据
     */
    public GenerateMarkdownResp generateFile(GenerateMarkdownReq req){
        try{
            String data = req.getData();

            // 新增markdown文件信息
            FileMarkdown fileMarkdown = createFileMarkdownInfo();
            if(fileMarkdownMapper.insertSelective(fileMarkdown) <= 0){
                throw new FileException(FileErrorEnum.ADD_MARKDOWN_FILE_INFO_ERROR);
            }

            // 写入html文件
            FileUtils.checkFolder(fileMarkdown.getHtmlFilePath());
            saveHtmlFile(data, fileMarkdown.getHtmlFilePath() + fileMarkdown.getHtmlFileName());

            // 写入markdown文件
            FileUtils.checkFolder(fileMarkdown.getMdFilePath());
            saveMarkdownFile(data,fileMarkdown.getMdFilePath() + fileMarkdown.getMdFileName());

            GenerateMarkdownResp resp = new GenerateMarkdownResp();
            resp.setId(fileMarkdown.getId());
            resp.setUrl(fileMarkdown.getMdFileUrl());
            return resp;
        }catch (Exception e){
            throw new FileException(e,FileErrorEnum.FAIL);
        }
    }

    /**
     * 创建markdown文件信息
     */
    private FileMarkdown createFileMarkdownInfo(){
        Date createDate = new Date();
        String currentDate = DateUtils.formatDate(DateUtils.DATE1,createDate);
        FileMarkdown record = new FileMarkdown();
        record.setId(PrimaryKeyUtils.getUuid());
        record.setCreateTime(createDate);
        record.setMdFileName(record.getId() + ".md");
        record.setMdFilePath(FileUtils.checkSeparator(fileConfigUtils.getMarkdown().getLocal()) + currentDate + File.separator);
        record.setMdFileUrl(FileUtils.checkSeparator(fileConfigUtils.getMarkdown().getRemote()) + currentDate + File.separator);
        record.setHtmlFileName(record.getId() + ".html");
        record.setHtmlFilePath(FileUtils.checkSeparator(fileConfigUtils.getHtml().getLocal()) + currentDate + File.separator);
        record.setHtmlFileUrl(FileUtils.checkSeparator(fileConfigUtils.getHtml().getRemote()) + currentDate + File.separator);
        record.setStatus(MarkdownFileStatusEnums.USE.getCode());
        return record;
    }

    /**
     * 保存为html文件
     * @param data 数据
     * @param fileName 文件名称
     */
    private void saveHtmlFile(String data, String fileName) throws Exception{
        if(StringUtils.isNotEmpty(data)){
            data = data.replace("\n","\\n");
        }

        List<String> list = Files.readAllLines(Paths.get(markdownTemplate), StandardCharsets.UTF_8);

        // 替换数据
        String temp;
        for(int i=0;i<list.size();i++){
            temp = list.get(i);
            if(temp.contains(replaceKey)){
                list.set(i, temp.replace(replaceKey,data));
                break;
            }
        }

        try(FileOutputStream out = new FileOutputStream(fileName)) {
            for(String row : list){
                out.write(row.getBytes(StandardCharsets.UTF_8));
            }
            out.flush();
        }

    }

    /**
     * 保存markdown文件
     * @param data 数据
     * @param fileName 文件名称
     */
    private void saveMarkdownFile(String data, String fileName) throws Exception{
        try(FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(data);
            fileWriter.flush();
        }
    }
}

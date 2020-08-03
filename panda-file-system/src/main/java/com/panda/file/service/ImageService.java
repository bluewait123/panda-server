package com.panda.file.service;

import com.panda.common.utils.DateUtils;
import com.panda.common.utils.PrimaryKeyUtils;
import com.panda.common.utils.StringUtils;
import com.panda.file.enums.FileErrorEnum;
import com.panda.file.enums.ImageFileStatusEnums;
import com.panda.file.exception.FileException;
import com.panda.file.utils.FileConfigUtils;
import com.panda.file.utils.FileUtils;
import com.panda.file.vo.UploadImageStringReq;
import com.panda.file.vo.item.QueryImageFileItem;
import com.panda.mybatis.mapper.FileImageMapper;
import com.panda.mybatis.po.FileImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 上传图片服务
 * @author w
 * @date 2020-07-08
 */
@Slf4j
@Service
public class ImageService {
    @Autowired
    private FileConfigUtils fileConfigUtils;

    @Autowired
    private FileImageMapper fileImageMapper;

    /**
     * 获取文件信息
     * @param ids 文件ID数组
     * @return QueryImageFileResp
     */
    public List<QueryImageFileItem> getImageFileInfo(String[] ids){
        List<FileImage> fileImageList = fileImageMapper.selectByPrimaryKeys(ids);
        if(StringUtils.isEmpty(fileImageList)){
            throw new FileException(FileErrorEnum.FILE_INFO_NOT_EXIST);
        }

        List<QueryImageFileItem> list = new ArrayList<>();
        QueryImageFileItem item;
        for(FileImage image : fileImageList){
            item = new QueryImageFileItem();
            item.setId(image.getId());
            item.setSourcePic(image.getFileUrlPath() + image.getFileName());
            item.setBigPic(image.getFileUrlPath() + image.getBigPic());
            item.setMiddlePic(image.getFileUrlPath() + image.getMiddlePic());
            item.setSmallPic(image.getFileUrlPath() + image.getSmallPic());
            list.add(item);
        }

        return list;
    }

    /**
     * 上传图片文件
     * @param file 前端上传的文件
     */
    public void uploadImage(MultipartFile[] file){

    }

    /**
     * 上传图片文件（BASE64）
     * @param req 请求信息
     */
    public List<String> uploadImage(UploadImageStringReq req){
        List<String> result = new ArrayList<>();
        Date date = new Date();
        String currentDate = DateUtils.formatDate(DateUtils.DATE1,date);
        String filePath = FileUtils.checkSeparator(fileConfigUtils.getImage().getLocal()) + currentDate + File.separator;
        String url = FileUtils.checkSeparator(fileConfigUtils.getImage().getRemote()) + currentDate + File.separator;

        String fileType = req.getFileType();
        String[] fileInfo;
        FileImage fileImage;
        for(String file : req.getFiles()){
            fileInfo = file.split(",");
            if(StringUtils.isEmpty(fileType)){
                fileType = fileInfo[0];
                fileType = fileType.substring(fileType.indexOf("/")+1,fileType.indexOf(";"));
            }

            // 保存文件信息
            fileImage = createFileImageInfo(fileType,filePath,date,url,req.getStatus());
            if(fileImageMapper.insertSelective(fileImage) <= 0){
                throw new FileException(FileErrorEnum.SAVE_FILE_INFO_ERROR);
            }

            // 保存文件至本地
            FileUtils.saveFile(fileInfo[1],filePath,fileImage.getFileName());

            // 返回ID
            result.add(fileImage.getId());
        }
        return result;
    }

    /**
     * 创建图片文件信息
     * @param fileType 文件类型
     * @param filePath 文件路径
     * @param createTime 创建时间
     * @param status 文件状态
     * @return FileImage
     */
    private FileImage createFileImageInfo(String fileType, String filePath, Date createTime, String url, Integer status){
        FileImage record = new FileImage();
        record.setId(PrimaryKeyUtils.getUuid());
        record.setCreateTime(createTime);
        record.setFileName(record.getId() + "." + fileType);
        record.setFilePath(filePath);
        record.setFileUrlPath(url);
        record.setBigPic(PrimaryKeyUtils.getUuid() + "." + fileType);
        record.setMiddlePic(PrimaryKeyUtils.getUuid() + "." + fileType);
        record.setSmallPic(PrimaryKeyUtils.getUuid() + "." + fileType);
        record.setStatus(null == status ? ImageFileStatusEnums.NONE.getCode() : status);
        return record;
    }

}

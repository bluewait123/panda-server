package com.panda.file.utils;

import com.panda.common.utils.StringUtils;
import com.panda.file.enums.FileErrorEnum;
import com.panda.file.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 文件处理工具包
 * @author w
 * @date 2020-07-08
 */
@Slf4j
public class FileUtils {
    /**
     * 保存文件
     * @param file 前端上传的文件
     * @param filePath 文件路径
     * @param fileName 文件名称
     */
    public static void saveFile(MultipartFile file, String filePath, String fileName){
        // 检查文件夹是否存在
        checkFolder(filePath);

        // 检查文件路径是否带/
        filePath = checkSeparator(filePath);

        try{
            // 写入文件
            writeFile(filePath + fileName, file.getBytes());
        }catch (Exception e){
            throw new FileException(e,FileErrorEnum.FAIL);
        }
    }

    /**
     * 保存文件
     * @param base64Code BASE64数据
     * @param filePath 文件路径
     * @param fileName 文件名称
     */
    public static void saveFile(String base64Code, String filePath, String fileName){
        if(StringUtils.isEmpty(base64Code)){
            throw new FileException(FileErrorEnum.BASE64_DATA_EMPTY_ERROR);
        }

        // 检查文件夹是否存在
        checkFolder(filePath);

        // 检查文件路径是否带/
        filePath = checkSeparator(filePath);

        // 写入文件
        byte[] buffer = Base64.decodeBase64(base64Code);
        writeFile(filePath + fileName, buffer);

    }

    /**
     * 检查文件夹是否存在
     * @param filePath 文件路径
     */
    public static void checkFolder(String filePath){
        File folder = new File(filePath);
        if(!folder.exists()){
            if(!folder.mkdirs()){
                throw new FileException(FileErrorEnum.CREATE_FOLDER_ERROR);
            }
        }
    }

    /**
     * 检查有没有/
     * @param filePath 文件路径
     */
    public static String checkSeparator(String filePath){
        // 如果没有/补一个
        if(filePath.lastIndexOf(File.separator) != filePath.length() -1){
            filePath += File.separator;
        }

        return filePath;
    }

    /**
     * 写入文件
     * @param fileFullName 文件名称（包含路径）
     * @param data 文件数据
     */
    private static void writeFile(String fileFullName, byte[] data){
        try(FileOutputStream out = new FileOutputStream(fileFullName)) {
            out.write(data);
            out.flush();
        }catch (Exception e){
            throw new FileException(e, FileErrorEnum.FAIL);
        }
    }
}

package com.panda.boss.adapter.file;

import com.panda.boss.adapter.file.item.QueryImageFileItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 响应图片文件信息
 * @author w
 * @date 2020-07-08
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class QueryImageFileResp extends FileResp {
    /**
     * 响应信息集合
     */
    private List<QueryImageFileItem> data;
}

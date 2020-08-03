package com.panda.boss.service;

import com.github.pagehelper.PageInfo;
import com.panda.boss.adapter.FileSystemAdapter;
import com.panda.boss.adapter.file.GenerateMarkdownReq;
import com.panda.boss.adapter.file.GenerateMarkdownResp;
import com.panda.boss.adapter.file.QueryImageFileReq;
import com.panda.boss.adapter.file.QueryImageFileResp;
import com.panda.boss.adapter.file.item.QueryImageFileItem;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.boss.enums.FileSystemTranCodeEnum;
import com.panda.boss.enums.NoteDataStatusEnum;
import com.panda.boss.enums.NoteErrorEnum;
import com.panda.boss.enums.NotePublicTypeEnum;
import com.panda.boss.exception.NoteException;
import com.panda.boss.vo.note.*;
import com.panda.boss.vo.note.item.MultipleQueryNoteDataItem;
import com.panda.boss.vo.note.item.SimpleQueryNoteDataItem;
import com.panda.common.enums.BossErrorEnum;
import com.panda.common.service.BasicService;
import com.panda.common.utils.StringUtils;
import com.panda.common.vo.BossPageResp;
import com.panda.mybatis.mapper.NoteDataMapper;
import com.panda.mybatis.mapper.NoteTypeMapper;
import com.panda.mybatis.po.NoteData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 笔记信息管理
 * @author w
 * @date 2020-07-06
 */
@Slf4j
@Service
public class NoteDataService extends BasicService {

    @Value("${request.http.file.internet}")
    private String fileSystemUrl;

    @Autowired
    private NoteDataMapper noteDataMapper;

    @Autowired
    private NoteTypeMapper noteTypeMapper;

    @Autowired
    private FileSystemAdapter fileSystemAdapter;

    /**
     * 查询笔记信息列表（简单查询）
     * @param req 请求信息
     * @param userInfo 用户信息
     * @return QueryNoteDataResp
     */
    public PageInfo<SimpleQueryNoteDataItem> simple(SimpleQueryNoteDataReq req, SessionUserInfo userInfo){
        // 分页查询
        req.setPaging();
        return getPageInfo(noteDataMapper.selectByUserId(userInfo.getId()));
    }

    /**
     * 查询笔记信息列表（高级查询）
     * @param req 请求信息
     * @param userInfo 用户信息
     */
    public BossPageResp multiple(MultipleQueryNoteDataReq req, SessionUserInfo userInfo){
        MultipleQueryNoteDataResp noteDataResp = new MultipleQueryNoteDataResp();

        // 分页查询笔记信息
        req.setPaging();
        PageInfo<MultipleQueryNoteDataItem> pageInfo = getPageInfo(noteDataMapper.selectByTitle(req,userInfo.getId()));
        List<MultipleQueryNoteDataItem> list = pageInfo.getList();
        if(StringUtils.isNotEmpty(list)){
            // 笔记类型ID
            List<String> noteTypeIds = new ArrayList<>();
            for(MultipleQueryNoteDataItem item : list){
                if(StringUtils.isNotEmpty(item.getNoteTypePathsId())){
                    for(String type : item.getNoteTypePathsId().split("/")){
                        if(!noteTypeIds.contains(type)){
                            noteTypeIds.add(type);
                        }
                    }
                }

                // 补全截图访问URL
                item.setScreenImageUrl(fileSystemUrl + item.getScreenImageUrl());

                // 限制200字以内
                if(StringUtils.isNotEmpty(item.getData()) && item.getData().length() > 200){
                    item.setData(item.getData().substring(0,200));
                }
            }

            // 笔记内容
            noteDataResp.setList(list);
            // 查询笔记类型
            noteDataResp.setTypes(noteTypeMapper.selectByIds(noteTypeIds));
        }

        BossPageResp pageResp = new BossPageResp();
        pageResp.setPaging(pageInfo);
        pageResp.setCode(BossErrorEnum.SUCCESS.getCode());
        pageResp.setMsg(BossErrorEnum.SUCCESS.getMsg());
        pageResp.setData(noteDataResp);
        return pageResp;
    }

    /**
     * 获取指定类型下所有笔记信息
     * @param req 请求信息
     * @param userInfo 用户信息
     * @return PageInfo<MultipleQueryNoteDataItem>
     */
    public PageInfo<MultipleQueryNoteDataItem> queryByNoteType(QueryNoteDataByNoteTypeReq req, SessionUserInfo userInfo){
        // 分页查询笔记信息
        req.setPaging();
        PageInfo<MultipleQueryNoteDataItem> pageInfo = getPageInfo(noteDataMapper.selectByNoteType(req,userInfo.getId()));

        List<MultipleQueryNoteDataItem> list = pageInfo.getList();
        if(StringUtils.isNotEmpty(list)){
            for(MultipleQueryNoteDataItem item : list){
                // 限制200字以内
                if(StringUtils.isNotEmpty(item.getData()) && item.getData().length() > 200){
                    item.setData(item.getData().substring(0,200));
                }

                // 补全截图访问URL
                item.setScreenImageUrl(fileSystemUrl + item.getScreenImageUrl());
            }
        }

        return pageInfo;
    }

    /**
     * 查询笔记信息
     * @param id ID
     * @return 笔记内容
     */
    public String detail(String id){
        NoteData noteData = noteDataMapper.selectByPrimaryKey(Integer.valueOf(id));
        Optional.ofNullable(noteData).orElseThrow(() -> new NoteException(NoteErrorEnum.NOTE_DATA_NOT_EXITS));
        return noteData.getData();
    }

    /**
     * 查询标签信息列表
     * @param userId 用户ID
     * @return List<String>
     */
    public List<String> queryTags(String userId){
        List<String> result= new ArrayList<>();
        String tags = noteDataMapper.selectTagsByUserId(userId);
        if(StringUtils.isNotEmpty(tags)){
            for(String tag : tags.split(",")){
                if(!result.contains(tag)){
                    result.add(tag);
                }
            }
        }
        return result;
    }

    /**
     * 新增笔记信息
     * @param req 请求信息
     * @param userInfo 用户信息
     */
    public void add(AddNoteDataReq req, SessionUserInfo userInfo){
        // 生成markdown文件
        GenerateMarkdownReq fileReq = new GenerateMarkdownReq();
        fileReq.setData(req.getData());
        GenerateMarkdownResp resp = fileSystemAdapter.request(FileSystemTranCodeEnum.GENERATE_MARKDOWN, fileReq, GenerateMarkdownResp.class);

        // 查询截图访问URL
        QueryImageFileReq imageFileReq = new QueryImageFileReq();
        imageFileReq.setIds(new String[]{req.getScreenImageId()});
        QueryImageFileResp imageFileResp = fileSystemAdapter.request(FileSystemTranCodeEnum.GET_IMAGE_FILE_INFO,imageFileReq, QueryImageFileResp.class);
        List<QueryImageFileItem> imageFiles = imageFileResp.getData();

        // 新增笔记信息
        NoteData record = new NoteData();
        record.setCreateTime(new Date());
        record.setUserId(userInfo.getId());
        record.setNoteType(req.getNoteType());
        record.setTitle(req.getTitle());
        record.setTags(req.getTags());
        record.setData(req.getData());
        record.setFileId(resp.getId());
        record.setFileUrl(resp.getUrl());
        record.setScreenImageUrl(null != imageFiles && imageFiles.size() > 0 ? imageFiles.get(0).getSourcePic() : null );
        record.setScreenImageId(req.getScreenImageId());
        record.setPublicType(NotePublicTypeEnum.PRIVATE.getCode());
        record.setStatus(NoteDataStatusEnum.NORMAL.getCode());
        if(noteDataMapper.insertSelective(record) <= 0){
            throw new NoteException(NoteErrorEnum.NOTE_DATA_ADD_ERROR);
        }
    }
}

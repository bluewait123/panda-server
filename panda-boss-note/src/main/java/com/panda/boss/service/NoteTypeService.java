package com.panda.boss.service;

import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.boss.enums.NoteErrorEnum;
import com.panda.boss.enums.NoteTypeStatusEnum;
import com.panda.boss.exception.NoteException;
import com.panda.boss.vo.note.AddNoteTypeReq;
import com.panda.common.utils.PrimaryKeyUtils;
import com.panda.common.utils.StringUtils;
import com.panda.mybatis.mapper.NoteTypeMapper;
import com.panda.mybatis.po.NoteType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 笔记种类管理
 * @author w
 * @date 2020-07-06
 */
@Slf4j
@Service
public class NoteTypeService {

    @Autowired
    private NoteTypeMapper noteTypeMapper;

    /**
     * 获取所有笔记信息
     * @param userId 用户ID
     * @return List<NoteType>
     */
    public List<NoteType> findAll(String userId){
        return noteTypeMapper.selectByUserId(userId);
    }

    /**
     * 新增笔记种类
     * @param req 请求信息
     * @param userInfo 用户信息
     */
    public String add(AddNoteTypeReq req, SessionUserInfo userInfo){
        NoteType parentNote = StringUtils.isEmpty(req.getParentId()) ? null : noteTypeMapper.selectByPrimaryKey(req.getParentId());

        NoteType noteType = new NoteType();
        noteType.setId(PrimaryKeyUtils.getUuid());
        noteType.setUserId(userInfo.getId());
        noteType.setTypeName(req.getTypeName());
        noteType.setParentId(req.getParentId());
        noteType.setStatus(NoteTypeStatusEnum.ENABLE.getCode());
        if(null != parentNote){
            noteType.setLevel(parentNote.getLevel() + 1);
            noteType.setPathsId(parentNote.getPathsId() + "/" + noteType.getId());
            noteType.setPathsName(parentNote.getPathsName() + "/" + noteType.getTypeName());
        }else{
            noteType.setLevel(1);
            noteType.setPathsId(noteType.getId());
            noteType.setPathsName(noteType.getTypeName());
        }

        if(noteTypeMapper.insertSelective(noteType) <= 0){
            throw new NoteException(NoteErrorEnum.NOTE_TYPE_ADD_ERROR);
        }

        return noteType.getId();
    }

}

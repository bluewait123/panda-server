package com.panda.mybatis.po;

import lombok.Data;

@Data
public class NoteType {
    private String id;

    private String parentId;

    private String userId;

    private String typeName;

    private Integer level;

    private String pathsId;

    private String pathsName;

    private Integer status;
}
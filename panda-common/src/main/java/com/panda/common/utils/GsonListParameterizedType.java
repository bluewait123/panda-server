package com.panda.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GsonListParameterizedType implements ParameterizedType {
    private Class clazz;

    public GsonListParameterizedType(Class clz) {
        clazz = clz;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{clazz};
    }

    @Override
    public Type getRawType() {
        return List.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}

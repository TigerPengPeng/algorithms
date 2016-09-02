package com.dlut.sorts;

import java.lang.reflect.Array;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月02日 上午10:54
 * @description:
 */
public class ArrayUtils<T> {

    public static <T> T[] newArray(Class<T[]> type, int size) {
        return type.cast(Array.newInstance(type.getComponentType(), size));
    }
}

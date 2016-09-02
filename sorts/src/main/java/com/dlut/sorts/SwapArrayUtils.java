package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午5:30
 * @description:
 */
public class SwapArrayUtils {

    public static <T> void swap(T[] array, int i, int k) {
        if (array == null || i == k) {
            return;
        }

        T guard = array[i];
        array[i] = array[k];
        array[k] = guard;
    }
}

package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午5:26
 * @description:
 */
public class PrintArrayUtils {

    public static void print(int[] array) {
        if (array == null) {
            return;
        }

        for (int item : array) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }

    public static <T> void print(T[] array) {
        if (array == null) {
            return;
        }

        for (T item : array) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }
}

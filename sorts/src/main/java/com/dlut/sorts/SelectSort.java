package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午7:13
 * @description:
 */
public class SelectSort {

    public static <T extends Comparable<? super T>> void sort(T[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            T min = A[i];

            for (int k = i+1; k < A.length; k++) {
                if (CompareUtils.lessThan(A[k], min)) {
                    min = A[k];
                    minIndex = k;
                }
            }

            if (minIndex != i) {
                SwapArrayUtils.swap(A, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {4, 1, 122, 6, 2, 55, 22};
        sort(A);
        PrintArrayUtils.print(A);
    }
}

package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午5:18
 * @description:
 */
public class BubbleSort {

    public static <T extends Comparable<? super T>> T[] sort(T[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }

        boolean flag = true;
        for (int i = 0; i < A.length && flag; i++) {
            flag = false;
            for (int k = A.length-1; k > i; k--) {
                if (CompareUtils.lessThan(A[k], A[k-1])) {
                    flag = true;
                    SwapArrayUtils.swap(A, k, k-1);
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {4, 1, 122, 6, 2, 55, 22};
        sort(A);
        PrintArrayUtils.print(A);
    }
}

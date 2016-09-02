package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午5:46
 * @description:
 */
public class InsertSort {

    public static <T extends Comparable<? super T>> void sort(T[] A) {
        if (A != null) {
            sort(A, 0, A.length - 1);
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] A, int low, int high) {
        if (A == null || low == high) {
            return;
        }

        T guard;
        for (int i = low + 1; i <= high; i++) {
            int k = i - 1;
            guard = A[i];

            while (k >= low && CompareUtils.biggerThan(A[k], guard)) {
                A[k+1] = A[k];
                k--;
            }
            A[k+1] = guard;
        }
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {4, 1, 122, 6, 2, 55, 22};
        sort(A, 2, 5);
        PrintArrayUtils.print(A);

        sort(A);
        PrintArrayUtils.print(A);
    }
}

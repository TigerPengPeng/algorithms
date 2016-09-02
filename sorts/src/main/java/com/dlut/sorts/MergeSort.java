package com.dlut.sorts;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月02日 上午10:34
 * @description:
 */
public class MergeSort {

    public static <T extends Comparable<? super T>> void sort(T[] A) {
        if (A != null) {
            sort(A, 0, A.length - 1);
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] A, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            sort(A, low, middle);
            sort(A, middle + 1, high);
            merge(A, low, middle, high);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] A, int low, int middle, int high) {
        int len1 = middle - low + 1;
        int len2 = high - middle;

        List<T> array1 = new ArrayList<T>(len1);
        List<T> array2 = new ArrayList<T>(len2);
        for (int i = low; i <= middle; i++) {
            array1.add(A[i]);
        }
        for (int i = middle + 1; i <= high; i++) {
            array2.add(A[i]);
        }

        int index = low;
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (CompareUtils.lessThan(array1.get(index1), array2.get(index2))) {
                A[index++] = array1.get(index1++);
            } else {
                A[index++] = array2.get(index2++);
            }
        }

        while (index1 < len1) {
            A[index++] = array1.get(index1++);
        }
        while (index2 < len2) {
            A[index++] = array2.get(index2++);
        }
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {4, 1, 122, 6, 2, 55, 22};
        sort(A);
        PrintArrayUtils.print(A);
    }
}

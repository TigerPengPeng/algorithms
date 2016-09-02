package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午7:18
 * @description:
 */
public class QuickSort {

    public static <T extends Comparable<? super T>> void sort(T[] A) {
        if (A != null) {
            sort(A, 0, A.length - 1);
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] A, int low, int high) {
        if (A == null || low == high) {
            return;
        }

        if (low < high) {
            int partition = partition(A, low, high);
            sort(A, low, partition);
            sort(A, partition + 1, high);
        }
    }

    public static <T extends Comparable<? super T>> int partition(T[] A, int low, int high) {
        T key = A[low];

        while (low < high) {
            while (low < high && CompareUtils.biggerThan(A[high], key)) {
                high--;
            }
            SwapArrayUtils.swap(A, high, low);

            while (low < high && CompareUtils.lessThan(A[low], key)) {
                low++;
            }
            SwapArrayUtils.swap(A, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {4, 1, 122, 6, 2, 55, 22};
        sort(A);
        PrintArrayUtils.print(A);
    }
}

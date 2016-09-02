package com.dlut.sorts;

/**
 * @package: com.dlut.sorts
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月02日 上午11:52
 * @description:
 */
public class BinarySearch {

    public static <T extends Comparable<? super T>> int getIndex(T[] A, T target) {
        if (A == null) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        int mid = (low + high) / 2;

        while (!CompareUtils.equals(target, A[mid])) {
            if (CompareUtils.lessThan(target, A[mid])) {
                high = mid;
            } else {
                low = mid;
            }

            mid = (low + high) / 2;
            if (low == mid && !CompareUtils.equals(target, A[mid])) {
                return -1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] {1, 2, 4, 6, 22, 55, 122, 555, 666};
        Integer target = 22;
        int index = getIndex(A, target);
        System.out.println(index);
        index = getIndex(A, 233);
        System.out.println(index);
    }
}

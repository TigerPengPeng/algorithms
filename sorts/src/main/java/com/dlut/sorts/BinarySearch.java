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
        while (low <= high) {
            int mid = (low + high) / 2;
            if (CompareUtils.lessThan(target, A[mid])) {
                high = mid - 1;
            } else if (CompareUtils.biggerThan(target, A[mid])) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
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

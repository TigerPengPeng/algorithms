package com.dlut.interviews.arr;

import com.dlut.sorts.PrintArrayUtils;

public class NoDuplicateNumber {


    /**
     * 一个数组只有一个数字出现了一次，其他数字都出现了两次，找到这个唯一出现过一次的数字
     *
     * @param arr
     * @return
     */
    public static int findOnlyNoDuplicateNumber(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr can not be null");
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int target = arr[0];
        for (int i = 1; i < arr.length; i++) {
            target ^= arr[i];
        }

        return target;
    }

    /**
     * 一个数组只有两个数字出现了一次，其他数字都出现了两次，找到这两个出现过一次的数字
     *
     * @param arr
     * @return
     */
    public static int[] findTwoNoDuplicateNumber(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr can not be null");
        }
        if (arr.length < 2) {
            throw new IllegalArgumentException("length of arr can not < 2");
        }
        if (arr.length == 2) {
            if (arr[0] != arr[1]) {
                return arr;
            } else {
                return null;
            }
        }

        int xorResult = arr[0];
        for (int i = 1 ; i < arr.length; i++) {
            xorResult ^= arr[i];
        }

        // 找到某个位是1
        int bitIndex = 0;
        for (int i = 0; i < 32; i++) {
            if ((xorResult & (1 << i)) != 0) {
                bitIndex = i;
                break;
            }
        }

        int[] result = new int[]{0, 0};
        // 根据 bitIndex 区分数组成两个数组
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & (1 << bitIndex)) != 0) {
                result[0] ^= arr[i];

            } else {
                result[1] ^= arr[i];
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 4, 5, 6, 8, 4, 5, 6};
        System.out.println(findOnlyNoDuplicateNumber(arr));

        int[] arr2 = new int[] {1, 1, 4, 5, 6, 8, 4, 5, 6, 9};
        PrintArrayUtils.print(findTwoNoDuplicateNumber(arr2));
    }
}

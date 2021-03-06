/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 *
 */
package com.dlut.interviews.top.k;

import com.dlut.sorts.PrintArrayUtils;
import com.dlut.sorts.RandomArrUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ray
 * date 2019年02月22日
 */
public class MaxK {
    public static void main(String[] args) {
        int[] arr = RandomArrUtil.randomIntArr(30);
        PrintArrayUtils.print(arr);

        for (int i = 0; i < 20; i++) {
            System.out.println("max K=" + i);
            int[] maxK = topK(arr, i);
            PrintArrayUtils.print(maxK);
        }
    }


    public static int[] topK(int[] arr, int topK) {
        if (arr == null || arr.length <= topK) {
            return arr;
        }

        if (topK == 0) {
            return null;
        }

        int[] runArr = Arrays.copyOf(arr, arr.length);

        return topK(runArr, 0, runArr.length - 1, topK);
    }

    private static int[] topK(int arr[], int beginIndex, int endIndex, int topK) {
        if (topK == 1) {
            return topOne(arr, beginIndex, endIndex);

        } else if (topK == 2) {
            return topTwo(arr, beginIndex, endIndex);

        } else {

            int pIndex = partition(arr, beginIndex, endIndex);

            if (endIndex - pIndex == topK) {
                // [pIndex + 1, endIndex]
                return Arrays.copyOfRange(arr, pIndex + 1, endIndex + 1);

            } else if (endIndex - pIndex + 1 == topK) {
                // [pIndex, endIndex]
                return Arrays.copyOfRange(arr, pIndex, endIndex + 1);

            } else if (endIndex - pIndex > topK) {
                // topK(arr, pIndex + 1, endIndex, topK)
                return topK(arr, pIndex + 1, endIndex, topK);

            } else if (endIndex - pIndex + 1 < topK) {
                // [pIndex, endIndex] + topK(arr, beginIndex, pIndex - 1, topK - (endIndex - pIndex + 1))
                int[] leftTop = topK(arr, beginIndex, pIndex - 1, topK - (endIndex - pIndex + 1));
                int[] rightTop = Arrays.copyOfRange(arr, pIndex, endIndex + 1);
                return mergeArr(leftTop, rightTop);

            } else {
                throw new IllegalStateException("unexpected condition");
            }
        }
    }

    private static int[] mergeArr(int[] arr1, int[] arr2) {
        int[] resultArr = new int[arr1.length + arr2.length];

        int index = 0;
        for (int element : arr1) {
            resultArr[index++] = element;
        }

        for (int element : arr2) {
            resultArr[index++] = element;
        }

        return resultArr;
    }

    /**
     * find top 2 number at range [beginIndex, endIndex]
     *
     * @param arr
     * @param beginIndex
     * @param endIndex
     * @return
     */
    private static int[] topTwo(int[] arr, int beginIndex, int endIndex) {
        int[] topTwoArr = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = beginIndex; i <= endIndex; i++) {
            if (arr[i] > topTwoArr[1]) {
                topTwoArr[1] = arr[i];

                // sure topTwoArr[0] > topTwoArr[1]
                if (topTwoArr[1] > topTwoArr[0]) {
                    swap(topTwoArr, 0, 1);
                }
            }
        }

        return topTwoArr;
    }

    /**
     * find top 1 number at range [beginIndex, endIndex]
     *
     * @param arr
     * @param beginIndex
     * @param endIndex
     * @return
     */
    private static int[] topOne(int[] arr, int beginIndex, int endIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = beginIndex; i <= endIndex; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new int[]{max};
    }


    /**
     * 每次 partition 之后，key左边的值都比key小， key右边的值逗逼key大
     * @param arr
     * @param beginIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr, int beginIndex, int endIndex) {
        int key = arr[beginIndex];

        while (beginIndex < endIndex) {

            // 可以更改 arr[endIndex] <= key, 改成 partition 右边的数比 arr[partition] 小, 实现找反向的 topK
            while (beginIndex < endIndex && arr[endIndex] >= key) {
                endIndex--;
            }
            swap(arr, beginIndex, endIndex);


            // 可以更改 arr[beginIndex] >= key, 改成 partition 右边的数比 arr[partition] 小, 实现找反向的 topK
            while (beginIndex < endIndex && arr[beginIndex] <= key) {
                beginIndex++;
            }
            swap(arr, beginIndex, endIndex);
        }

        return beginIndex;
    }

    private static void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

}

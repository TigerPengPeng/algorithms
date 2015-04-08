package com.dlut.sorts.radixSort;

import com.dlut.sorts.counting.CoutingSort;

/**
 * Created by ray on 15-4-8.
 * 简单的基数排序（基于计数排序）
 * 调用d次CoutingSort类中的digitCoutingSort方法，时间复杂度为O(d(n+k))a
 * 由于使用计数排序作为辅助，所以基数排序只能排列非负整数
 */
public class RadixSort {

    /**
     * return one number's digit length
     * @param number
     * @return
     */
    public static int getDigitLength(int number) {
        return String.valueOf(number).length();
    }

    /**
     * return the max number of one array
     * @param array
     * @return
     */
    public static int getMaxNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     *
     * @param origin
     * @param d         origin数组中的最大位数
     * @return
     */
    public static int[] radixSort(int[] origin, int d) {
        int[] sort = origin;
        for (int i = 0; i < d; i++) {
            sort = CoutingSort.digitCoutingSort(sort, i);
        }
        return sort;
    }

    /**
     *
     * @param origin
     * @return
     */
    public static int[] radixSort(int[] origin) {
        int max = getMaxNumber(origin);
        int maxDigitLength = getDigitLength(max);
        return radixSort(origin, maxDigitLength);
    }

    public static void main(String[] args) {
        int[] data = new int[] {12,54,333,30,266,43,5,13};
        int[] sort = radixSort(data);
        for (int item : sort) {
            System.out.println(item);
        }
    }
}
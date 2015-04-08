package com.dlut.sorts.counting;

/**
 * Created by ray on 15-4-7.
 * 简单的计数排序实现
 * 时间复杂度为O(n)
 * 不过由于使用数组的index下标来存储value=index的个数，所以只支持非负整数的排序
 * 且保证计数排序为稳定排序
 */
public class CoutingSort {

    /**
     * 返回一个int类型的数据的倒数第reverseIndex位的value
     * 若reverseIndex超过number的位数，则返回0
     * @param number
     * @param reverseIndex
     * @return
     */
    public static int getReverseIndexValue(int number, int reverseIndex) {
        return (int)((number % Math.pow(10, reverseIndex+1)) / Math.pow(10, reverseIndex));
    }

    /**
     *
     * @param oringin
     * @param reverseIndex 支持只对数字的某一位（个位，十位，百位...）进行计数排序
     * （如对数字123，reverseIndex=0位值为3，reverseIndex=1位值为2，reverseIndex=2位值为1，reverseIndex=3位值为0）
     * @return
     * @return
     */
    public static int[] digitCoutingSort(int[] oringin, int reverseIndex) {
        if (reverseIndex < 0) {
            throw new RuntimeException("reverseIndex must > 0");
        }
        int[] sort = new int[oringin.length];
        int[] temp = new int[10];

        // temp[digit]包含等于digit的元素个数
        for (int item : oringin) {
            // 获取int数据第reverseIndex位置的value
            int digit = getReverseIndexValue(item, reverseIndex);
            temp[digit] = temp[digit] + 1;
        }
        // temp[i]包含小于或等于i的元素个数
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i-1];
        }
        // 为了保证为稳定排序，所以从后往前遍历origin数组
        for (int i = oringin.length-1; i >=0; i--) {
            // 获取int数据第reverseIndex位置的value
            int digit = getReverseIndexValue(oringin[i], reverseIndex);
            sort[temp[digit]-1] = oringin[i];
            temp[digit] = temp[digit] - 1;
        }
        return sort;
    }

    /**
     *
     * @param origin
     * @param maxValue

     */
    public static int[] coutingSort(int[] origin, int maxValue) {

        int[] sort = new int[origin.length];
        int[] temp = new int[maxValue+1];

        // temp[i]包含等于i的元素个数
        for (int item : origin) {
            temp[item] = temp[item] + 1;
        }
        // temp[i]包含小于或等于i的元素个数
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i-1];
        }

        // 为了保证为稳定排序，所以从后往前遍历origin数组
        for (int i = origin.length-1; i >= 0; i--) {
            sort[temp[origin[i]]-1] = origin[i];
            temp[origin[i]] = temp[origin[i]] - 1;
        }
        return sort;
    }

    public static void main(String[] args) {
        int[] data = new int[] {12,54,333,30,266,43,5,13};
        int[] sort = digitCoutingSort(data, 0);

//        int[] sort = coutingSort(data, 5);
        for (int item : sort) {
            System.out.println(item);
        }
    }
}

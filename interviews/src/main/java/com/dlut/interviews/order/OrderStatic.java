package com.dlut.interviews.order;

import com.dlut.interviews.template.TemplateUtil;

/**
 * Created by ray on 15-4-9.
 * 找出集合中第i个顺序统计量
 * 在一组元素组成的集合中，最小值是第1个顺序统计量(i=1)，最大值是第n个顺序统计量(i=n)
 * 1. 对randomizedSelect算法而言
 * 平均时间复杂度为O(n)
 * 若partition每次都是最差的分隔(分隔成[n-1,0])，则为最差情况，时间复杂度为O(n^2)
 *
 * 2. 对select算法而言
 * 最坏的情况下时间复杂度都为O(n)
 * 因为select算法先通过划分区间找到了一个近似中位数的值，这样使用partition方法效率更高
 * 而寻找近似中位数的算法的时间复杂度为O(n)
 */
public class OrderStatic {

    /**
     *
     * @param A
     * @param i
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T select(T[] A, int i) {
        if (i <= 0) {
            throw new RuntimeException("value of i must > 0");
        }
        return select(A, 0, A.length-1, i);
    }

    /**
     * TODO 非随机的第i个顺序量统计，需要更改partition算法,目前partition算法不支持选择key值
     * @param A
     * @param low
     * @param high
     * @param i
     * @param <T>
     * @return
     */
    private static <T extends Comparable> T select(T[] A, int low, int high, int i) {
        return null;
    }

    /**
     *
     * @param A
     * @param i
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T randomizedSelect(T[] A, int i) {
        if (i <= 0) {
            throw new RuntimeException("value of i must > 0");
        }
        return randomizedSelect(A, 0, A.length-1, i);
    }

    /**
     *
     * @param A     集合
     * @param low
     * @param high
     * @param i     第i个顺序统计量
     * @param <T>
     * @return
     */
    private static <T extends Comparable> T randomizedSelect(T[] A, int low, int high, int i) {
        if (low == high) {
            return A[low];
        }
        int q = partition(A, low, high);
        int k = q - low + 1;
        if (i == k) {
            return A[q];
        } else if (i < k) {
            return randomizedSelect(A, low, q-1, i);
        } else {
            return randomizedSelect(A, q+1, high, i-k);
        }
    }


    /**
     *
     * @param A
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    public static <T extends Comparable> int partition(T[] A, int low, int high) {
        return partition(A, low, high, A[high]);
    }

    /**
     * TODO 目前的partition算法是不支持选择key值的, 保留key的形参是为了后期扩展
     * @param A
     * @param low
     * @param high
     * @param key
     * @param <T>
     * @return
     */
    private static <T extends Comparable> int partition(T[] A, int low, int high, T key) {
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (TemplateUtil.compare(A[j], key) <= 0) {
                i++;
                TemplateUtil.swap(A, i, j);
            }
        }
        TemplateUtil.swap(A, i+1, high);
        return i+1;
    }


    public static void main(String[] args) {

        Integer[] data = new Integer[]{22,1,65,122,6,2,55,22,66,33,5,9,22,65,79,90,0,101,120,22};
        for (int i = 1; i <= data.length; i++) {
            Integer value = randomizedSelect(data, i);
            System.out.print(value + ",");
        }

    }
}

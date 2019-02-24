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
    public static <T extends Comparable> T middleSelect(T[] A, int i) {
        if (i <= 0) {
            throw new RuntimeException("value of i must > 0");
        }
        return middleSelect(A, 0, A.length-1, i);
    }

    /**
     * 非随机的第i个顺序量统计
     * @param A
     * @param low
     * @param high
     * @param i
     * @param <T>
     * @return
     */
    private static <T extends Comparable> T middleSelect(T[] A, int low, int high, int i) {
        if (low == high) {
            return A[low];
        }
        int q = middlePartition(A, low, high);
        int k = q - low + 1;
        if (i == k) {
            return A[q];
        } else if (i < k) {
            return middleSelect(A, low, q-1, i);
        } else {
            return middleSelect(A, q+1, high, i-k);
        }
    }

    /**
     * 需要找到近似中位数的index，然后swap(A, low, midIndex)
     * @param A
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    private static <T extends Comparable> int middlePartition(T[] A, int low, int high) {
        T middle = FindApproximateMiddle.findApproximateMiddle(A, low, high);
        // 找到近似中位数的index
        int index = FindApproximateMiddle.findApproximateMiddleIndex(A,  low, high, middle);

        // 交换A[low] 和 A[index]
        TemplateUtil.swap(A, low, index);
        return randomizedPartition(A, low, high);
    }


    /**
     * key的选值只能是A[low]，若不是会出错。如果想自定义key=A[i]，也只能swap(A,low,i)，key=A[low]是不能改变的
     * @param A
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    private static <T extends Comparable> int randomizedPartition(T[] A, int low, int high) {
        T key = A[low];
        while (low < high) {
            while (low < high && TemplateUtil.compare(A[high], key) >= 0) {
                high--;
            }
            TemplateUtil.swap(A, low, high);
            while (low < high && TemplateUtil.compare(A[low], key) <=0 ) {
                low++;
            }
            TemplateUtil.swap(A, low, high);
        }
        return low;
    }


    public static void main(String[] args) {

        Integer[] data = new Integer[]{22,1,65,122,6,2,55,22,66,33,5,9,22,65,79,90,0,101,120,22};
        for (int i = 1; i <= data.length; i++) {
            Integer value = middleSelect(data, i);
            System.out.print(value + ",");
        }

    }
}

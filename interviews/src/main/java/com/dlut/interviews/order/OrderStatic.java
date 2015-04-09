package com.dlut.interviews.order;

import com.dlut.interviews.template.TemplateUtil;

/**
 * Created by ray on 15-4-9.
 * 找出集合中第i个顺序统计量
 */
public class OrderStatic {

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
     * @return
     */
    public static <T extends Comparable> int partition(T[] A, int low, int high) {

        T key = A[low];

        while (low < high) {
            while (low < high && TemplateUtil.compare(A[high], key) > 0) {
                high--;
            }
            TemplateUtil.swap(A, low, high);

            while (low < high && TemplateUtil.compare(A[low], key) < 0) {
                low++;
            }
            TemplateUtil.swap(A, low, high);
        }
        return low;
    }


    public static void main(String[] args) {

        Integer[] data = new Integer[]{230,1,122,6,2,55,22,66,33,5,9,65,79,90,0,101,120,4};
        Integer value = randomizedSelect(data, 7);
        System.out.println(value);
    }
}

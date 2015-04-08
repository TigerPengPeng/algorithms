package com.dlut.sorts.bucket;


import com.dlut.sorts.bucket.data.structure.LinkedList;

/**
 * Created by ray on 15-4-8.
 * 简单桶排序
 * 桶排序要求输入的数组A，对数组A的每一个元素A[i]满足0<=A[i]<1
 * 若输入的数组A均匀分布，则桶排序的效率就更高
 * 桶排序需要一个额外的辅助空间（数组+链表），所以需要手动定义该数据结构
 */
public class BucketSort {

    /**
     *
     * @param origin
     * @return
     */
    public static Double[] bucketSort(double[] origin) {

        // 初始化链表数组
        LinkedList<Double>[] array = new LinkedList[origin.length];

        for (int i = 0; i < origin.length; i++) {
            // 计算出在链表数组中的下标
            int index = (int)(origin.length * origin[i]);

            if (array[index] == null) {
                array[index] = new LinkedList<Double>();
            }
            // 插入到链表中
            array[index].headInsert(origin[i]);
        }

        // 对链表数组的每个链表进行插入排序
        for (LinkedList<Double> item : array) {
            if (item != null) {
                item.sort();
            }
        }
        // 将链表的数据存储到Double数组中
        Double[] sort = new Double[origin.length];
        int i = 0;
        int onceSize = 0;
        for (LinkedList<Double> item : array) {
            if (item != null) {
                i += onceSize;
                onceSize = item.copyToArray(sort, i);
            }
        }
        return sort;
    }


    public static void main(String[] args) {

        double[] data = new double[] {0,0.12,0.54,0.333,0.5,0.12,0.30,0.266,0.43,0.5,0.13};

        Double[] sort = bucketSort(data);
        for (double item : sort) {
            System.out.println(item);
        }
    }
}

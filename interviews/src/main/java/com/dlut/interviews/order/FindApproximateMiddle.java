package com.dlut.interviews.order;

import com.dlut.interviews.template.TemplateUtil;
import com.dlut.sorts.insert.InsertSort;

/**
 * Created by ray on 15-4-9.
 * 找出一个集合中的近似中位数
 * 采用分而治之的思想，将集合分割成ceil(n/5)个集合，分别求出这ceil(n/5)个集合的中位数，放入到集合B中
 * 然后继续递归找出集合B中的中位数
 * 在5个数找中位数的方法中，调用了插入排序的方法
 * 时间复杂度为 O(n)
 * 最后返回的值为集合的近似中位数
 */
public class FindApproximateMiddle {

    /**
     *
     * @param A
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T findApproximateMiddle(T[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int size = A.length / 5;
        int mod = A.length % 5;
        int arraySize = mod == 0 ? size : (size + 1);
        T[] array = (T[])TemplateUtil.getTemplateArray(A[0].getClass(), arraySize);

        int counter = 0;
        int i = 0;
        // 对集合按照[i,i+4]各个部分进行插入排序，并返回part的中位数
        for (; i < size * 5; i += 5) {
            InsertSort.sort(A, i, i + 4);
            array[counter++] = A[i+2];
        }
        // 处理余下部分数据(len < 5)， 返回该集合的下中位数
        InsertSort.sort(A, i, A.length-1);
        if (mod % 2 == 0) {
            array[counter++] = A[i+mod/2-1];
        } else {
            array[counter++] = A[i+mod/2];
        }
        return findApproximateMiddle(array);
    }


    public static void main(String[] args) {
        Integer[] A = new Integer[]{4, 1, 122, 6, 2, 55, 22};
        Integer value = findApproximateMiddle(A);
        System.out.println(value);
    }
}

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
     */
    public static final int SPLIT_SIZE = 5;

    /**
     * 根据index获得该index的下中位坐标
     * @param index
     * @return
     */
    public static int getMiddleIndex(int index) {
        if (index % 2 == 0) {
            return index / 2 - 1;
        } else {
            return index / 2;
        }
    }

    /**
     *
     * @param low
     * @param high
     * @return
     */
    public static int getLenthByRange(int low, int high) {
        return high - low + 1;
    }

    /**
     *
     * @param A
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T findApproximateMiddle(T[] A, int low, int high) {
        if (low == high) {
            return A[low];
        }
        int size = getLenthByRange(low, high) / SPLIT_SIZE;
        int mod = getLenthByRange(low, high) % SPLIT_SIZE;
        int arraySize = mod == 0 ? size : (size + 1);
        T[] array = (T[])TemplateUtil.getTemplateArray(A[0].getClass(), arraySize);

        int counter = 0;
        int i = low;
        // 对集合按照[i,i+SPLIT_SIZE-1]各个部分进行插入排序，并返回part的中位数
        for (; i < low + size * SPLIT_SIZE; i += SPLIT_SIZE) {
            InsertSort.sort(A, i, i + SPLIT_SIZE - 1);
            array[counter++] = A[i+getMiddleIndex(SPLIT_SIZE)];
        }
        if (mod > 0) {
            // 处理余下部分数据[i, high)， 返回该集合的下中位数
            InsertSort.sort(A, i, high);
            array[counter++] = A[i+getMiddleIndex(mod)];
        }
        // 递归继续寻找近似中位数
        return findApproximateMiddle(array, 0, array.length - 1);
    }

    /**
     * 寻找近似中位数的index
     * @param A
     * @param low
     * @param high
     * @param middleValue
     * @param <T>
     * @return
     */
    public static <T extends Comparable> int findApproximateMiddleIndex(T[] A, int low, int high, T middleValue) {

        int middleIndex = low + getMiddleIndex(SPLIT_SIZE);

        int size = getLenthByRange(low, high) / SPLIT_SIZE;
        int mod = getLenthByRange(low, high) % SPLIT_SIZE;

        // 遍历每个子集合的中位数，找到middle的index
        for ( ; middleIndex < low + size * SPLIT_SIZE; middleIndex += SPLIT_SIZE) {
            if (TemplateUtil.compare(A[middleIndex], middleValue) == 0) {
                return middleIndex;
            }
        }
        // 若近似中位数在余下长度不足SPLIT_SIZE的集合中
        return low + size * SPLIT_SIZE + getMiddleIndex(mod);
    }


    public static void main(String[] args) {
        Integer[] A = new Integer[]{22,1,65,122,6,2,55,22,66, 33,5,9,22,65, 79,90,0,101,120, 50};
        Integer value = findApproximateMiddle(A, 9, A.length-1);
        System.out.println(value);

        for (Integer item : A) {
            System.out.print(item + " ");
        }
        System.out.println("\n");

        int index = findApproximateMiddleIndex(A, 9, A.length-1, value);
        System.out.println(index);
    }
}

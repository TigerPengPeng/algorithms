package com.dlut.interviews.order;

import com.dlut.interviews.template.TemplateUtil;

/**
 * Created by ray on 15-4-9.
 * 同时找出一个集合中的最大值和最小值
 * 时间复杂度为O(n)
 */
public class FindMaxAndMin {

    /**
     * 返回一个集合中的max和min
     * 若集合元素个数为0或集合为空，直接让其抛出异常
     * @param collection
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] findMaxAndMin(T[] collection) {

        T[] result = (T[])TemplateUtil.getTemplateArray(collection[0].getClass(), 2);

        // 若集合的元素个数为1,则返回min，max为collection[0]
        if (collection.length == 1) {
            result[0] = collection[0];
            result[1] = collection[0];
            return result;
        }

        T min;
        T max;
        int i = 0;
        // 若集合的长度为偶数
        if (collection.length % 2 == 0) {
            T[] sort = TemplateUtil.sortTwoValue(collection[0], collection[1]);
            min = sort[0];
            max = sort[1];
            i = 2;
        } else {
            min = max = collection[0];
            i = 1;
        }
        while (i < collection.length) {
            // 成对处理余下的元素
            T[] sort = TemplateUtil.sortTwoValue(collection[i], collection[i+1]);
            // 更新min和max
            if (TemplateUtil.compare(min, sort[0]) > 0) {
                min = sort[0];
            }
            if (TemplateUtil.compare(max, sort[1]) < 0) {
                max = sort[1];
            }
            i += 2;
        }
        result[0] = min;
        result[1] = max;
        return result;
    }


    public static void main(String[] args) {
        Double[] data = new Double[] {5.0,7.0,66.0,8.0,3.0,0.0,3.0,5.0,55.0,44.0,32.0,90.0};
        Double[] result = findMaxAndMin(data);
        System.out.println(result[0] + "," + result[1]);
    }
}

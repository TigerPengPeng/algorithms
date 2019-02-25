package com.dlut.interviews.template;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ray on 15-4-9.
 * java泛型工具类
 */
public class TemplateUtil {

    /**
     * 交换数组中下标i，k的数据
     * @param array
     * @param i
     * @param k
     * @param <T>
     * @return
     */
    public static <T> void swap(T[] array, int i, int k) {
        T temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }

    /**
     * 比较两个数字的大小，返回length=2的数组，array[0]=min, array[1]=max
     * @param o1
     * @param o2
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] sortTwoValue(T o1, T o2) {
        T[] sort = (T[]) getTemplateArray(o1.getClass(), 2);
        if (o1.compareTo(o2) <= 0) {
            sort[0] = o1;
            sort[1] = o2;
        } else {
            sort[0] = o2;
            sort[1] = o1;
        }
        return sort;
    }


    /**
     *
     * @param o1
     * @param o2
     * @param <T>
     * @return
     */
    public static <T extends Comparable> int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    /**
     * 返回泛型数组
     * @param type
     * @param size
     * @param <T>
     * @return
     */
    public static <T> T[] getTemplateArray(Class<T> type, int size) {
        return (T[]) Array.newInstance(type, size);
    }

    /**
     * 返回泛型ArrayList
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> getTemplateArrayList(Class<T> type) {
        return new ArrayList<T>();
    }

    /**
     * 返回泛型LinkedList
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> getTemplateLinkedList(Class<T> type) {
        return new LinkedList<T>();
    }



    public static void main(String[] args) {
        List<String> list = getTemplateArrayList(String.class);
        System.out.println(list);
        list = getTemplateLinkedList(String.class);
        System.out.println(list);
    }
}

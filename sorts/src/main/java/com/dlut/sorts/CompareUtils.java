package com.dlut.sorts;

/**
 * @package: com.dlut.sorts.review
 * @class:
 * @author: 黄鹏
 * @date: 2016年09月01日 下午5:42
 * @description:
 */
public class CompareUtils {

    public static <T extends Comparable<? super T>> boolean lessThan(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    public static <T extends Comparable<? super T>> boolean biggerThan(T item1, T item2) {
        return item1.compareTo(item2) > 0;
    }

    public static <T extends Comparable<? super T>> boolean lessThanOrEquals(T item1, T item2) {
        return item1.compareTo(item2) < 0 || equals(item1, item2);
    }

    public static <T extends Comparable<? super T>> boolean biggerThanOrEquals(T item1, T item2) {
        return item1.compareTo(item2) > 0 || equals(item1, item2);
    }

    public static <T extends Comparable<? super T>> boolean equals(T item1, T item2) {
        if (item1 == null && item2 == null) {
            return true;
        } else {
            return item1.compareTo(item2) == 0;
        }
    }
}

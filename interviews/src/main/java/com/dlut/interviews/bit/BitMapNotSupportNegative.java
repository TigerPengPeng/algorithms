package com.dlut.interviews.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitMapNotSupportNegative {

    /**
     * 一个int数据占32位
     */
    private static final int UNIT = 32;

    /**
     * i / UNIT = i >> SHIFT
     */
    private static final int SHIFT = 5;

    /**
     * 一个数对于2的N次幂求模，等于: 该数 & (2的N次幂 - 1)
     * MASK = UNIT - 1
     * i % UNIT = i & MASK
     */
    private static final int MASK = 0x1F;

    private static final int DEFAULT_SIZE = 32;

    private int[] container = new int[DEFAULT_SIZE];

    /**
     * 计算 value 应在的下标
     *
     * @param value
     * @return
     */
    private int getIndex(int value) {
        // equals i / UNIT
        return value >> SHIFT;
    }

    /**
     * 判断 value 是否超过当前 container 存储的上限
     * @param value
     * @return
     */
    private boolean isOutOfSize(int value) {
        return getIndex(value) > container.length - 1;
    }

    /**
     * container 扩容
     * @param value
     */
    private void expandCapacity(int value) {
        int needSize = getIndex(value) + 1;

        int[] newContainer = new int[needSize];
        System.arraycopy(container, 0, newContainer, 0, container.length);
        container = newContainer;
    }

    /**
     * 求 value % 32
     *
     * @param value
     * @return
     */
    private int getMod(int value) {
        // equals abs(i) % UNIT
        return Math.abs(value) & MASK;
    }

    /**
     * 获取 index 下标的值
     *
     * @param index
     * @return
     */
    private int getContainerValue(int index) {
        if (container[index] == 0) {
            return 0;
        }
        return container[index];
    }

    /**
     * set value
     *
     * @param value
     */
    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value can not < 0");
        }

        if (isOutOfSize(value)) {
            expandCapacity(value);
        }

        container[getIndex(value)] = getContainerValue(getIndex(value)) | (1 << getMod(value));
    }

    /**
     * @param value
     * @return
     */
    public boolean exists(int value) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(getIndex(i));

        if (isOutOfSize(value)) {
            return false;
        }

        return (getContainerValue(getIndex(value)) & (1 << (getMod(value)))) != 0;
    }

    /**
     * @param value
     */
    public void remove(int value) {
        if (isOutOfSize(value)) {
            return;
        }

        if (getContainerValue(getIndex(value)) == 0) {
            return;
        }
        container[getIndex(value)] = getContainerValue(getIndex(value)) & ~(1 << getMod(value));
    }

    public List<Integer> sort() {
        List<Integer> sortList = new ArrayList<Integer>(container.length * UNIT);

        for (int key = 0; key < container.length; key++) {
            int value = container[key];

            for (int i = 0; i < UNIT; i++) {
                if (((1 << i) & value) != 0) {
                    sortList.add(key * UNIT + i);
                }
            }
        }
        return sortList;
    }

    public static void main(String[] args) {
        int[] data = {0, 1, 43, 90, 32, 31, 63, 95, 734, 32, 31, 89, 5, 71, 98, 273, 59, 817, 457, 189, 238, 409, 21, 384};
        int[] temp = {89, 78, 90, 95, 457};

        BitMapNotSupportNegative bitMapSupportNegative = new BitMapNotSupportNegative();

        for (int item : data) {
            bitMapSupportNegative.setValue(item);
        }
        for (int item : temp) {
            if (bitMapSupportNegative.exists(item)) {
                System.out.println(item);
            }
        }
        System.out.println(bitMapSupportNegative.sort());
    }

}

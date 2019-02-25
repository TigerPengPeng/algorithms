package com.dlut.interviews.bit;


import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ray on 15-4-7.
 * 使用位来存储int类型数据
 * 由于位存储的性质，所以存储后的数据有去重的效果
 */
public class BitMapSupportNegative {

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

    /**
     * BitMapSupportNegative Container
     * 选择 TreeMap 是为了较好的支持存负数
     * 如果bitMap 不用支持负数，则用 int[] 代理即可
     */
    private Map<Integer, Integer> container = new TreeMap<Integer, Integer>();

    /**
     * 计算 value 应在的下标
     *
     * @param value
     * @return
     */
    private int getIndex(int value) {
        if (value < 0) {
            return -((Math.abs(value) >> SHIFT) + 1);
        } else {
            // equals i / UNIT
            return value >> SHIFT;
        }
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
        if (!container.containsKey(index)) {
            return 0;
        }
        return container.get(index);
    }

    /**
     * set value
     *
     * @param value
     */
    public void setValue(int value) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(index);
//        int newValue = getContainerValue(index) | (i << mod);
        container.put(getIndex(value),
                getContainerValue(getIndex(value)) | (1 << getMod(value)));
    }

    /**
     * @param value
     * @return
     */
    public boolean exists(int value) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(getIndex(i));

        return (getContainerValue(getIndex(value)) & (1 << (getMod(value)))) != 0;
    }

    /**
     * @param value
     */
    public void remove(int value) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(getIndex(i));
//        int newValue = getContainerValue(getIndex(i)) & ~(1 << getMod(i));
        if (getContainerValue(getIndex(value)) == 0) {
            return;
        }
        container.put(getIndex(value),
                getContainerValue(getIndex(value)) & ~(1 << getMod(value)));
    }

    /**
     * @return
     */
    public List<Integer> sort() {
        List<Integer> sortList = new ArrayList<Integer>(container.size() * UNIT);
        for (Integer key : container.keySet()) {
            int value = container.get(key);
            for (int i = 0; i < UNIT; i++) {
                if (((1 << i) & value) != 0) {
                    if (key < 0) {
                        sortList.add(-(Math.abs(key + 1) * UNIT + i));
                    } else {
                        sortList.add(key * UNIT + i);
                    }
                }
            }
        }
        return sortList;
    }

    /**
     * BitMap测试main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] data = {-1, -43, -90, 32, 31, 63, 95, 734, 32, 31, 89, 5, 71, 98, 273, 59, 817, 457, 189, 238, 409, 21, 384};
        int[] temp = {89, 78, 90, 95, 457};

        BitMapSupportNegative bitMapSupportNegative = new BitMapSupportNegative();

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

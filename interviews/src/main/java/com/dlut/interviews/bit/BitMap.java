package com.dlut.interviews.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ray on 15-4-7.
 * 使用位来存储int类型数据
 *
 */
public class BitMap {

    /**
     * 一个int数据占32位
     */
    public static final int UNIT = 32;

    /**
     * i / UNIT = i >> SHIFT
     */
    public static final int SHIFT = 5;

    /**
     * MASK = UNIT - 1
     * i % UNIT = i & MASK
     */
    public static final int MASK = 0x1F;

    /**
     * BitMap Container
     */
    private static Map<Integer, Integer> container = new HashMap<Integer, Integer>();

    /**
     *
     * @param i
     * @return
     */
    public static int getIndex(int i) {
        // equals i / UNIT
        return i >> SHIFT;
    }

    /**
     *
     * @param i
     * @return
     */
    public static int getMod(int i) {
        // equals i % UNIT
        return i & MASK;
    }

    /**
     *
     * @param index
     * @return
     */
    public static int getContainerValue(int index) {
        if (!container.containsKey(index)) {
            return 0;
        }
        return container.get(index);
    }

    /**
     *
     * @param i
     */
    public static void set(int i) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(index);
//        int newValue = getContainerValue(index) | (i << mod);
        container.put(getIndex(i),
                getContainerValue(getIndex(i)) | (1 << getMod(i)));
    }

    /**
     *
     * @param i
     * @return
     */
    public static boolean exists(int i) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(getIndex(i));

        if ((getContainerValue(getIndex(i)) & (1 << (getMod(i)))) > 0
                || (getContainerValue(getIndex(i)) & (1 << (getMod(i)))) == (1 << MASK)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param i
     */
    public static void remove(int i) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(getIndex(i));
//        int newValue = getContainerValue(getIndex(i)) & ~(1 << getMod(i));
        if (getContainerValue(getIndex(i)) == 0) {
            return;
        }
        container.put(getIndex(i),
                getContainerValue(getIndex(i)) & ~(1 << getMod(i)));
    }

    /**
     *
     * @return
     */
    public static List<Integer> sort() {
        List<Integer> sortList = new ArrayList<Integer>(container.size() * UNIT);
        for (Integer key : container.keySet()) {
            int value = container.get(key);
            for (int i = 0; i < UNIT; i++) {
                if ((((1 << i) & value) > 0)
                        || (((1 << i) & value) == (1 << MASK))) {
                    sortList.add(key * UNIT + i);
                }
            }
        }
        return sortList;
    }

    public static void main(String[] args) {
        int [] data={32,31,63,95,734,89,5,71,98,273,59,817,457,189,238,409,21,384};
        for (int i = 0; i < data.length; i++) {
            set(data[i]);
        }
        System.out.println(exists(0));
        System.out.println(exists(31));
        System.out.println(exists(500));

        remove(89);

        System.out.println(sort());
    }
}

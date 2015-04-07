package com.dlut.interviews.bit;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ray on 15-4-7.
 * 使用位来存储int类型数据
 * 注意，BitMap中只能存储正整数和0，具体原因请参考“int在机器中是以补码的方式存储的”
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
    private Map<Integer, Integer> container = new HashMap<Integer, Integer>();

    /**
     *
     * @param i
     * @return
     */
    public int getIndex(int i) {
        // equals i / UNIT
        return i >> SHIFT;
    }

    /**
     *
     * @param i
     * @return
     */
    public int getMod(int i) {
        // equals i % UNIT
        return i & MASK;
    }

    /**
     *
     * @param index
     * @return
     */
    public int getContainerValue(int index) {
        if (!container.containsKey(index)) {
            return 0;
        }
        return container.get(index);
    }

    /**
     *
     * @param i
     */
    public void set(int i) {
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
    public boolean exists(int i) {
//        int index = getIndex(i);
//        int mod = getMod(i);
//        int containerValue = getContainerValue(getIndex(i));

        if ((getContainerValue(getIndex(i)) & (1 << (getMod(i)))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param i
     */
    public void remove(int i) {
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
    public List<Integer> sort() {
        List<Integer> sortList = new ArrayList<Integer>(container.size() * UNIT);
        for (Integer key : container.keySet()) {
            int value = container.get(key);
            for (int i = 0; i < UNIT; i++) {
                if (((1 << i) & value) != 0) {
                    sortList.add(key * UNIT + i);
                }
            }
        }
        return sortList;
    }

    /**
     * BitMap中只能存储正整数和0
     * 原因为int在机器中是以补码的方式存储的
     * @param args
     */
    public static void main(String[] args) {
        int [] data={32,31,63,95,734,89,5,71,98,273,59,817,457,189,238,409,21,384};

        BitMap bitMap = new BitMap();

        for (int i = 0; i < data.length; i++) {
            bitMap.set(data[i]);
        }
        System.out.println(bitMap.exists(0));
        System.out.println(bitMap.exists(31));
        System.out.println(bitMap.exists(500));

        bitMap.remove(89);

        System.out.println(bitMap.sort());
    }
}

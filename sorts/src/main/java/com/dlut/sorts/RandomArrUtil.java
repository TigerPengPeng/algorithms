package com.dlut.sorts;

import java.util.Random;

public class RandomArrUtil {

    public static int[] randomIntArr(int length) {
        int[] arr = new int[length];

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(1000) + 1;
        }

        return arr;
    }
}

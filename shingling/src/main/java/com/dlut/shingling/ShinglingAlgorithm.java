package com.dlut.shingling;

import com.dlut.shingling.util.AnalyzerUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by ray on 15-4-1.
 */
public class ShinglingAlgorithm {

    /**
     *
     * @param array1
     * @param array2
     * @return
     */
    public static double getSimilarity(String[] array1, String[] array2) {

        if (array1 == null || array2 == null) {
            throw new RuntimeException("array1 and array2 can't be null");
        }
        if (array1.length == 0 || array2.length == 0) {
            return 0;
        }

        int son = 0;
        double father = 0.0;

        for (String item1 : array1) {
            for (String item2 : array2) {
                if (item1.equals(item2)) {
                    son++;
                    break;
                }
            }
        }
        father = array1.length + array2.length - son;

        return son / father;
    }

    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public static double getSimilarity(List<String> list1, List<String> list2) {
        return getSimilarity(list1.toArray(new String[]{}),
                list2.toArray(new String[]{}));
    }



    public static void main(String[] args) throws IOException {

        String str1 = "北京酒仙桥如家大酒店";
        String str2 = "北京如家酒仙桥便捷大酒店";

        List<String> list1 = AnalyzerUtil.analyzer(str1);
        List<String> list2 = AnalyzerUtil.analyzer(str2);

        double similarity = getSimilarity(list1, list2);
        System.out.println(similarity);

    }
}

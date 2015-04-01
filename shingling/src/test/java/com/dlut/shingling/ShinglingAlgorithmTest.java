package com.dlut.shingling;

import com.dlut.shingling.util.AnalyzerUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShinglingAlgorithmTest {

    @Test
    public void testGetSimilarity() throws Exception {

        String str1 = "北京酒仙桥如家大酒店";
        String str2 = "北京如家酒仙桥便捷大酒店";

        List<String> list1 = AnalyzerUtil.analyzer(str1);
        List<String> list2 = AnalyzerUtil.analyzer(str2);

        double similarity = ShinglingAlgorithm.getSimilarity(list1, list2);
        System.out.println(similarity);
    }
}
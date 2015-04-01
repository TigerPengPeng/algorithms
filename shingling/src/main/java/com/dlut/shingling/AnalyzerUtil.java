package com.dlut.shingling;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 *
 */
public class AnalyzerUtil {
    public static List<String> Analyzer(String text) throws IOException {
        List<String> resultList = new ArrayList<String>();
        //创建分词对象
        Analyzer anal = new IKAnalyzer(true);
        StringReader reader = new StringReader(text);
        //分词
        TokenStream ts = anal.tokenStream("", reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        //遍历分词数据
        while(ts.incrementToken()){
            resultList.add(term.toString());
        }
        reader.close();
        anal.close();

        return resultList;

    }

    public static void main(String[] args) throws IOException {
        String text = "黄鹏是一个程序员";
        List<String> res = AnalyzerUtil.Analyzer(text);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}


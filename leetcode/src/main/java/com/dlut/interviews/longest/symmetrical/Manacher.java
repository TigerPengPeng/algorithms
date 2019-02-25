package com.dlut.interviews.longest.symmetrical;

/**
 * Created by ray on 15-4-6.
 * manacher回文串算法
 * 时间复杂度为O(n)
 */
public class Manacher {

    /**
     * 处理字符串的特殊字符
     */
    private char specialChar;

    /**
     * 处理过后的字符串
     */
    private char[] mainString;

    /**
     * 记录每个字符的最大回文半径
     */
    private int[] p;

    /**
     *
     * @param mainString
     */
    public Manacher(String mainString) {
        this(mainString.toCharArray());
    }

    /**
     *
     * @param mainString
     */
    public Manacher(char[] mainString) {
        this('$', mainString);
    }

    /**
     * 向原串中插入特殊字符, 特殊字符一定要是mainString没有的
     * for example
     * <input> mainString = "ab" </input>
     * <output> this.mainString = ['$', 'a', '$', 'b', '$'] </output>
     * @param specialChar
     * @param mainString
     */
    public Manacher(char specialChar, char[] mainString) {

        int len = 2 * mainString.length + 1;
        this.p = new int[len];
        this.mainString = new char[len];
        this.specialChar = specialChar;

        int i = 0;
        for (char c : mainString) {
            this.mainString[i++] = this.specialChar;
            this.mainString[i++] = c;
        }
        this.mainString[i] = this.specialChar;
    }

    /**
     * 返回a b中的最小值
     * @param a
     * @param b
     * @return
     */
    public int minimun(int a, int b) {
        return a < b ? a : b;
    }

    /**
     * 最大回文串算法
     * @return
     */
    public PalindromeString getMaxPalindromeString() {
        // 最大回文串长度
        int maxLen = 0;
        // 记录在i之前的回文串中，延伸到最右断的位置
        int maxId = 0;
        // 记录在i之前的回文串中，回文串对称点的位置
        int symmetricPoint = 0;
        // 记录最大回文串对象
        PalindromeString target = new PalindromeString();

        for (int i = 0; i < mainString.length; i++) {
            if (maxId > i) {
                // 根据回文串的特征，证明出以下公式
                p[i] = minimun(maxId-i, p[2*symmetricPoint-i]);
            } else {
                p[i] = 1;
            }
            // 由回文串对称性，向两边扩展，增加回文串长度
            while ((i-p[i] >=0) && (i+p[i] < mainString.length)
                    && mainString[i+p[i]] == mainString[i-p[i]]) {
                p[i]++;
            }

            // 更新maxId 和 symmetricPoint
            if (p[i] + i - 1 > maxId) {
                maxId = p[i] + i - 1;
                symmetricPoint = i;
            }
            // 更新maxLen
            if (p[i] > maxLen) {
                maxLen = p[i];
                target.setLength(maxLen-1);
                // k记录在原字符串中当前最大回文串的对称点
                int k = (i-1)/2;
                // 若最大回文串为偶数
                if (target.getLength() % 2 == 0) {
                    target.setIndex(k-target.getLength()/2+1);
                } else {
                    target.setIndex(k-target.getLength()/2);
                }

            }
        }
        return target;
    }


    public static void main(String[] args) {

        Manacher manacher = new Manacher("aaabbddddd");
        //System.out.println(manacher);
        PalindromeString target = manacher.getMaxPalindromeString();
        System.out.println(target);
    }
}

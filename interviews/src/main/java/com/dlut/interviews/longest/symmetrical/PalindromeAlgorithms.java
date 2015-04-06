package com.dlut.interviews.longest.symmetrical;

/**
 * Created by ray on 15-4-6.
 * 回文串算法
 */
public class PalindromeAlgorithms {

    /**
     * 回文串算法, 由某个字符向两边扩展的方式寻找最大回文串
     * 若字符串A为子串且为回文串，则通过向外扩展，只需要O(1)就可判断出字符串aAa也为回文串
     * 时间复杂度 O(n^2)
     * @param mainString
     * @return
     */
    public static PalindromeString expandFromOneChar(String mainString) {
        return expandFromOneChar(mainString.toCharArray());
    }

    /**
     * 回文串算法, 由某个字符向两边扩展的方式寻找最大回文串
     * 若字符串A为子串且为回文串，则通过向外扩展，只需要O(1)就可判断出字符串aAa也为回文串
     * 时间复杂度 O(n^2)
     * @param mainString
     * @return
     */
    public static PalindromeString expandFromOneChar(char[] mainString) {

        if (mainString == null || mainString.length == 0) {
            return null;
        }

        PalindromeString target = new PalindromeString();

        // 记录回文串长度
        int maxLength = 1;

        for (int pos = 0; pos < mainString.length; pos++) {

            // 若回文串为奇数
            int left = pos - 1;
            int right = pos + 1;

            while (left >= 0 && right < mainString.length &&
                    mainString[left] == mainString[right]) {
                left--;
                right++;
            }
            // 若找到的回文串比当前最大回文串大，则更新最大回文串
            int newLength = right - left - 1;
            if (newLength > maxLength) {
                maxLength = newLength;
                target.setLength(maxLength);
                target.setIndex(left + 1);
            }

            // 若回文串为偶数
            left = pos;
            right = pos + 1;

            while (left >= 0 && right < mainString.length &&
                    mainString[left] == mainString[right]) {
                left--;
                right++;
            }
            // 若找到的回文串比当前最大回文串大，则更新最大回文串
            newLength = right - left - 1;
            if (newLength > maxLength) {
                maxLength = newLength;
                target.setLength(maxLength);
                target.setIndex(left + 1);
            }
        }
        return target;
    }

    public static void main(String[] args) {

        String str = "aaabbddd";
        PalindromeString target = expandFromOneChar(str.toCharArray());
        System.out.println(target);
    }
}

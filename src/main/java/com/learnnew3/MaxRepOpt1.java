package com.learnnew3;

/**
 * @describtion: 1156. 单字符重复子串的最大长度
 * @author: CaiJm
 * @Date: 2021-12-31 13:53
 */
public class MaxRepOpt1 {
    public static int maxRepOpt1(String text) {
        char[] textChar = text.toCharArray();
        int left = 0, right = 1, sum = 1, max = 1, otherIdx = -1;
        char tempChar = textChar[0];
        while (right < textChar.length) {
            if (tempChar == textChar[right]) {
                sum++;
                right++;
            } else {
                if (otherIdx > left) {
                    if (findChar(textChar, 0, left, tempChar) || findChar(textChar, right + 1, textChar.length, tempChar)) {
                        max = Math.max(sum + 1, max);
                    } else {
                        max = Math.max(sum, max);
                    }
                    left = otherIdx;
                    right = otherIdx + 1;
                    sum = 1;
                    tempChar = textChar[otherIdx];
                } else {
                    otherIdx = right;
                    right++;
                }
            }
        }
        if (findChar(textChar, 0, left, tempChar) || findChar(textChar, right + 1, textChar.length, tempChar)) {
            max = Math.max(sum + 1, max);
        } else {
            max = Math.max(sum, max);
        }
        return max;
    }

    private static boolean findChar(char[] text, int begin, int end, char c) {
        for (; begin < end; begin++) {
            if (text[begin] == c) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        maxRepOpt1("aaabaaa");
    }
}

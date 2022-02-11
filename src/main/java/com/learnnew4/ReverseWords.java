package com.learnnew4;

/**
 * @describtion: 剑指 Offer 58 - I. 翻转单词顺序
 * @author: CaiJm
 * @Date: 2022-02-10 15:01
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        if (s.trim().length() == 0) return "";
        String[] s1 = s.split(" ");
        int begin = 0, end = s1.length - 1;
        while (begin < end) {
            String temp = s1[begin];
            s1[begin] = s1[end].trim();
            s1[end] = temp.trim();
            begin++;
            end--;
        }
        String res = "";
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].trim().length() == 0) {
                continue;
            }
            res += s1[i] + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        reverseWords(
                "  hello world!  ");
    }
}

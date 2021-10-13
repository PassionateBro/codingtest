package com.learn;

/**
 * @describtion: 1392. 最长快乐前缀
 * @author: CaiJm
 * @Date: 2021-10-13 15:33
 */
public class LongestPrefix {
    public static String longestPrefix(String s) {
        if (s.length() <= 1) {
            return "";
        }
        int n = s.length();
        int[] next = new int[n + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < n) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return s.substring(0, next[n]);
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("ababcabc"));
    }
}

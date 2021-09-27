package com.learn;

import java.util.Arrays;

/**
 * @describtion: 1170. 比较字符串最小字母出现频次
 * @author: CaiJm
 * @Date: 2021-09-08 9:34
 */
public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] w = new int[words.length];
        int[] res = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        int len = w.length;
        Arrays.sort(w);
        for (int i = 0; i < queries.length; i++) {
            int query = f(queries[i]);
            for (int j = 0; j < w.length; j++) {
                if (w[j] > query) {
                    res[i] = len - j;
                    break;
                }
            }
        }
        return res;
    }

    private int f(String s) {
        int smallest = 97 + 26;
        int times = 0;
        for (char c : s.toCharArray()) {
            if (c == smallest) {
                times++;
            }
            if (c < smallest) {
                smallest = c;
                times = 1;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        NumSmallerByFrequency numSmallerByFrequency = new NumSmallerByFrequency();
        numSmallerByFrequency.numSmallerByFrequency(new String[]{"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa", "babaa", "bbbbabaa"}
                , new String[]{"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab", "bbaaababba", "baaaaa"});
    }
}
package com.learnnew4;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @describtion: 2135. 统计追加字母可以获得的单词数
 * @author: CaiJm
 * @Date: 2022-02-07 14:51
 */
public class WordCount {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> set = new HashSet<>();

        for (String s : startWords) {
            char[] chars = s.toCharArray();
            int[] ints = new int[26];
            for (char c : chars) {
                ints[c - 'a']++;
            }
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 0) {
                    char[] chars1 = Arrays.copyOf(chars, chars.length + 1);
                    chars1[chars1.length - 1] = (char) ((int) 'a' + i);
                    Arrays.sort(chars1);
                    set.add(new String(chars1));
                }
            }
        }
        int res = 0;
        for (String s : targetWords) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (set.contains(new String(chars))) {
                res++;
            }
        }
        return res;
    }
}

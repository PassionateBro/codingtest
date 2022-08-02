package com.learnnew5;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @describtion: 720. 词典中最长的单词
 * @author: CaiJm
 * @Date: 2022-03-17 9:31
 */
public class LongestWord {
    public String longestWord(String[] words) {
        HashSet<Object> set = new HashSet<>();
        Arrays.sort(words);
        int len = 0;
        String res = "";
        for (String s : words) {
            if (s.length() == 1) {
                set.add(s);
                if (s.length() > len) {
                    len = s.length();
                    res = s;
                }
            } else {
                if (set.contains(s.substring(0, s.length() - 1))) {
                    set.add(s);
                    if (s.length() > len) {
                        len = s.length();
                        res = s;
                    }
                }
            }
        }
        return res;
    }
}

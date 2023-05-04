package com.compesation;

import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-13 10:15
 */
public class VowelStrings {
    static HashSet<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                res++;
            }
        }
        return res;
    }
}

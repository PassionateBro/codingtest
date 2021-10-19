package com.learn;

import java.util.Arrays;

/**
 * @describtion: 242. 有效的字母异位词
 * @author: CaiJm
 * @Date: 2021-10-15 11:08
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return String.valueOf(chars).equals(String.valueOf(chars1));
    }
}

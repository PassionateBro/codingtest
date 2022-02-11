package com.learnnew4;

import java.util.HashSet;

/**
 * @describtion: 剑指 Offer 50. 第一个只出现一次的字符
 * @author: CaiJm
 * @Date: 2022-02-07 14:22
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> garbage = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!set.add(c)) {
                garbage.add(c);
            }
        }

        for (char c : chars) {
            if (!garbage.contains(c)) return c;
        }
        return ' ';
    }
}

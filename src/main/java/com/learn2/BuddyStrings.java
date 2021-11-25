package com.learn2;

import java.util.Arrays;

/**
 * @describtion: 859. 亲密字符串
 * @author: CaiJm
 * @Date: 2021-11-23 9:13
 */
public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int len = s.length();
        char[] sChar = s.toCharArray();
        char[] goalChar = goal.toCharArray();
        int idx = 2;
        char[] me = new char[2];
        for (int i = 0; i < len; i++) {
            if (sChar[i] != goalChar[i]) {
                if (idx == 0) return false;
                if (idx == 2) {
                    me[0] = sChar[i];
                    me[1] = goalChar[i];
                    idx--;
                    continue;
                }
                if (idx == 1) {
                    if (me[0] == goalChar[i] && me[1] == sChar[i]) {
                        idx--;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (idx == 2) {
            Arrays.sort(sChar);
            for (int i = 1; i < sChar.length; i++) {
                if (sChar[i] == sChar[i - 1]) return true;
            }
            return false;
        }
        return idx == 0;
    }

    public static void main(String[] args) {
        buddyStrings("ab", "ba");
    }
}

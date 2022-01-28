package com.learnnew3;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-21 16:12
 */
public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        if (chars1.length != chars2.length) return false;
        if (chars1.length == 0 && chars2.length == 0) return true;
        int idx = 0;
        int sameNum = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[idx]) {
                idx++;
                sameNum++;
            } else {
                idx = 0;
                sameNum = 0;
            }
        }
        if (idx != 0) {
            for (int i = idx; i < chars2.length; i++) {
                if (chars2[i] != chars1[i - idx]) return false;
            }
            return true;
        }
        return false;
    }
}

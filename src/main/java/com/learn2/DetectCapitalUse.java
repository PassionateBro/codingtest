package com.learn2;

/**
 * @describtion: 520. 检测大写字母
 * @author: CaiJm
 * @Date: 2021-11-15 10:01
 */
public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        boolean up = true;
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (i == 1) {
                if (chars[1] >= 'A' && chars[1] <= 'Z') {
                    if (chars[0] >= 'a' && chars[0] <= 'z') {
                        return false;
                    }
                    up = true;
                } else {
                    up = false;
                }
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (up) {
                    continue;
                }
                return false;
            } else {
                if (up) {
                    return false;
                }
            }
        }
        return true;
    }
}

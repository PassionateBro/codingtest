package com.learnnew5;

/**
 * @describtion: 面试题 01.05. 一次编辑
 * @author: CaiJm
 * @Date: 2022-05-13 9:49
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int lenF = first.length(), lenS = second.length();
        if (Math.abs(lenF - lenS) > 1) return false;
        int chance = 1;
        char[] chars = first.toCharArray();
        char[] chars1 = second.toCharArray();
        int a = 0, b = 0;
        while (a < lenF && b < lenS) {
            if (chars[a] == chars1[b]) {
                a++;
                b++;
                continue;
            } else {
                if (chance == 0) {
                    return false;
                }
                if (lenF > lenS) {
                    a++;
                } else if (lenF < lenS) {
                    b++;
                } else {
                    a++;
                    b++;
                }
                chance--;
            }
        }
        return true;
    }
}

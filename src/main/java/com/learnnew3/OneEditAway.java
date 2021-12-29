package com.learnnew3;

/**
 * @describtion: 面试题 01.05. 一次编辑
 * @author: CaiJm
 * @Date: 2021-12-29 14:43
 */
public class OneEditAway {
    public static boolean oneEditAway(String first, String second) {
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();
        int lenF = firstChar.length, lenS = secondChar.length;
        if (Math.abs(lenF - lenS) >= 2) return false;
        int i = 0;
        if (lenF == lenS) {
            int k = 0;
            while (i < lenF) {
                if (firstChar[i] != secondChar[i]) {
                    k++;
                    if (k > 1) return false;
                }
                i++;
            }
        } else {
            char[] longS = lenF > lenS ? firstChar : secondChar;
            char[] shortS = lenF < lenS ? firstChar : secondChar;
            int k = 0, j = 0, m = 0;
            while (k < longS.length) {
                if (k == longS.length - 1) {
                    if (k > j  && longS[k] != shortS[j]) m++;
                    if (m > 1) return false;
                    break;
                }
                if (longS[k] != shortS[j]) {
                    m++;
                    if (m > 1) return false;
                } else {
                    j++;
                }
                k++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        oneEditAway("islander",
                "slander");
    }
}

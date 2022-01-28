package com.learnnew3;

import java.util.Arrays;

/**
 * @describtion: 1163. 按字典序排在最后的子串
 * @author: CaiJm
 * @Date: 2022-01-10 13:45
 */
public class LastSubstring {
    public String lastSubstring(String s) {
        char[] chars = s.toCharArray();
        int tempIdx = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (judge(i, tempIdx, chars, tempIdx - i + 1)) {
                tempIdx = i;
            }
        }
        return new String(Arrays.copyOfRange(chars, tempIdx, chars.length));
    }

    private boolean judge(int newIdx, int oldIdx, char[] chars, int range) {
        int i = newIdx, j = oldIdx;
        while (i <= chars.length && j < chars.length && range >= 0) {
            if (chars[i] != chars[j]) return chars[i] - chars[j] > 0;
            i++;
            j++;
            range--;
        }
        return i <= j;
    }

    public static void main(String[] args) {
        LastSubstring s = new LastSubstring();
        System.out.println(s.lastSubstring("cacacb"));
    }

}

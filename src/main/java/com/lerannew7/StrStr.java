package com.lerannew7;

/**
 * @describtion: 28. 找出字符串中第一个匹配项的下标
 * @author: CaiJm
 * @Date: 2023-03-08 10:53
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        char[] texts = haystack.toCharArray();
        char[] modes = needle.toCharArray();
        int[] next = new int[modes.length];
        int j = 0;
        for (int i = 1; i < modes.length; i++) {
            while (j > 0 && modes[i] != modes[j]) {
                j = next[j - 1];
            }
            if (modes[i] == modes[j]) {
                j++;
            }
            next[i] = j;
        }
        int k = 0;
        for (int i = 0; i < texts.length; i++) {
            while (k > 0 && modes[k] != texts[i]) {
                k = next[k - 1];
            }
            if (modes[k] == texts[i]) {
                k++;
            }
            if (k == modes.length) {
                return i - modes.length + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr sw = new StrStr();
        sw.strStr("mississippi","issip");
    }

}

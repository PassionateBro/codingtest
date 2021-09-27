package com.dongtaiguihua;

/**
 * @describtion: 392. 判断子序列
 * @author: CaiJm
 * @Date: 2021-08-26 11:06
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len = s.length();
        int len1 = t.length();
        int res = 0;
        int j = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            while (j < len1) {
                j++;
                if (c == t.charAt(j - 1)) {
                    res += 1;
                    break;
                }
            }
        }
        return res == len;
    }
}

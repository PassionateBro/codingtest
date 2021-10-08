package com.learn;

/**
 * @describtion: 1513. 仅含 1 的子串数
 * @author: CaiJm
 * @Date: 2021-09-28 9:22
 */
public class NumSub {
    public int numSub(String s) {
        int mod = 1000000007;
        int i = 0;
        char[] chars = s.toCharArray();
        int res = 0;
        while (i < chars.length) {
            if (chars[i] == '1') {
                int j = i;
                while (j + 1 < chars.length && chars[j + 1] == '1') {
                    j++;
                }
                long n = (j - i + 1);
                res = (res + (int) (n * (n + 1) / 2 % mod)) % mod;
                i = j + 1;
            } else {
                i++;
            }
        }
        return res;
    }
}

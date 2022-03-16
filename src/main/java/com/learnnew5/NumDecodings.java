package com.learnnew5;

/**
 * @describtion: 91. 解码方法
 * @author: CaiJm
 * @Date: 2022-03-02 9:43
 */
public class NumDecodings {

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}

package com.learnnew4;

/**
 * @describtion: 1573. 分割字符串的方案数
 * @author: CaiJm
 * @Date: 2022-01-27 14:34
 */
public class NumWays {
    static int mod = 1000000007;

    public static int numWays(String s) {
        int one = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') one++;
        }
        if (one == 0) {
            long len = (s.length()- 2) % mod;
            long res = (((len + 1) * len) / 2) % mod;
            return (int) (res % mod);
        }
        if (one % 3 > 0) return 0;
        int oneNum = one / 3;
        long sum = 0, a = 0, b = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') sum++;
            if (sum == oneNum) {
                if (chars[i] == '0') a++;
            }
            if (sum == 2 * oneNum) {
                if (chars[i] == '0') b++;
            }
        }
        long res = ((a + 1) * (b + 1)) % mod;
        return (int) res;
    }
}

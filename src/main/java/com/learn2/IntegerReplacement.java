package com.learn2;

/**
 * @describtion: 397. 整数替换
 * @author: CaiJm
 * @Date: 2021-11-19 9:16
 */
public class IntegerReplacement {
    public static int integerReplacement(long n) {
        return (int) dfs(n);
    }

    public static long dfs(long n) {
        if (n == 1) return 0;
        if ((n & 1) == 1) {
            // 奇数
            if ((((n - 1) >> 1) & 1) == 1 && n != 3) {
                n = n + 1;
            } else {
                n = n - 1;
            }
            return 1 + dfs(n);
        }
        return 1 + dfs(n >> 1);
    }

    public static void main(String[] args) {
        integerReplacement(2147483647);
    }
}

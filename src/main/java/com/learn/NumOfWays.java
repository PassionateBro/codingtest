package com.learn;

/**
 * @describtion: 1411. 给 N x 3 网格图涂色的方案数
 * @author: CaiJm
 * @Date: 2021-09-10 11:20
 */
public class NumOfWays {
    public int numOfWays(int n) {
        int mod = 1000000007;
        long fi0 = 6, fi1 = 6;
        for (int i = 2; i <= n; ++i) {
            long newFi0 = (2 * fi0 + 2 * fi1) % mod;
            long newFi1 = (2 * fi0 + 3 * fi1) % mod;
            fi0 = newFi0;
            fi1 = newFi1;
        }
        return (int) ((fi0 + fi1) % mod);
    }
}

package com.learn;

/**
 * @describtion: 1137. 第 N 个泰波那契数  用快速幂 矩阵
 * @author: CaiJm
 * @Date: 2021-09-07 10:11
 */
public class Tribonacci {
    public long tribonacci(int n) {
        long[][] x = new long[][]{{1, 1, 0}, {1, 0, 1}, {1, 0, 0}};
        long[][] r = new long[][]{{1, 1, 0}};
        while (n != 0) {
            if ((n & 1) == 1) {
                r = muti(x, r);
            }
            x = muti(x, x);
            n >>= 1;
        }
        return r[0][2];
    }

    /**
     * 矩阵相乘
     *
     * @return
     */
    public long[][] muti(long[][] x, long[][] r) {
        long[][] res = new long[3][3];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    res[i][j] += r[i][k] * x[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(100000));
    }
}

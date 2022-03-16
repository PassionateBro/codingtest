package com.learnnew5;

/**
 * @describtion: 343. 整数拆分
 * @author: CaiJm
 * @Date: 2022-03-07 15:49
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        if (n == 4) return 4;
        if (n == 5) return 6;
        int i = n % 3;
        int j = n / 3;
        if (i == 0) {
            return (int) Math.pow(3, j);
        } else {
            return (int) Math.pow(3, j - 1) * Math.max(3 * i, 3 + i);
        }
    }
}

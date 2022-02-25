package com.learnnew5;

/**
 * @describtion: 剑指 Offer 64. 求1+2+…+n
 * @author: CaiJm
 * @Date: 2022-02-14 13:56
 */
public class SumNums {
    int sum = 0;

    public int sumNums(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        sum += n;
        boolean a = n > 0 && (dfs(n - 1)) > 0;
        return sum;
    }
}

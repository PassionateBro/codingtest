package com.learnnew3;

/**
 * @describtion: 997. 找到小镇的法官
 * @author: CaiJm
 * @Date: 2021-12-20 15:42
 */
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n + 1];
        int[] bt = new int[n + 1];
        for (int[] ints : trust) {
            t[ints[0]]++;
            bt[ints[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (t[i] == 0 && bt[i] == n - 1) return i;
        }
        return -1;
    }
}

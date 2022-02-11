package com.learnnew4;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 1447. 最简分数
 * @author: CaiJm
 * @Date: 2022-02-10 9:18
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        if (n == 1) return new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (dp[i][j] != 1) {
                    objects.add(i + "/" + j);
                    deal(n, i, j, dp);
                }
            }
        }
        return objects;
    }

    private void deal(int n, int i, int j, int[][] dp) {
        for (int k = 1; k <= n / j + 1; k++) {
            if (j * k <= n) {
                dp[i * k][j * k] = 1;
            }
        }
    }
}

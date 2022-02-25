package com.learnnew5;

import java.util.Arrays;

/**
 * @describtion: 688. 骑士在棋盘上的概率
 * @author: CaiJm
 * @Date: 2022-02-17 9:32
 */
public class KnightProbability {
    int[][] move = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
    int n;
    double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        memo = new double[n][n][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);
        double rate = dfs(k, row, column);
        return rate;
    }

    //从位置（i,j）处走step步还在棋盘上的概率
    private double dfs(int step, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) return 0.0;
        if (step == 0) return 1.0;
        if (memo[i][j][step] != -1) return memo[i][j][step];
        double res = 0.0;
        for (int k = 0; k < 8; k++) {
            int x = i + move[k][0];
            int y = j + move[k][1];
            res += 0.125 * dfs(step - 1, x, y);
        }
        memo[i][j][step] = res;
        return res;
    }
}

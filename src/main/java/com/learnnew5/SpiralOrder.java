package com.learnnew5;

/**
 * @describtion: 剑指 Offer 29. 顺时针打印矩阵
 * @author: CaiJm
 * @Date: 2022-02-21 14:24
 */
public class SpiralOrder {
    int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int[][] dp = new int[matrix.length][matrix[0].length];
        int idx = 0;
        int dIdx = 0;
        int x = 0, y = 0;
        while (true) {
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && dp[x][y] == 0) {
                x = x + direct[dIdx][0];
                y = y + direct[dIdx][1];
                res[idx] = matrix[x][y];
                dp[x][y] = 1;
                idx++;
            } else {
                // back
                x = x - direct[dIdx][0];
                y = y - direct[dIdx][1];
                int times = 0;
                while (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || dp[x][y] == 1) {
                    if (times == 3) break;
                    dIdx++;
                    if (dIdx == 4) dIdx = 0;
                    x = x + direct[dIdx][0];
                    y = y + direct[dIdx][1];
                    times++;
                }
                if (times == 3) break;
            }
        }
        return res;
    }
}

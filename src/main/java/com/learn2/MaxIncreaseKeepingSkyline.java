package com.learn2;


/**
 * @describtion: 807. 保持城市天际线
 * @author: CaiJm
 * @Date: 2021-12-13 15:12
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] lineMax = new int[grid[0].length];
        int[] rowMax = new int[grid.length];
        int total = 0;
        // i - line  j - row
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                lineMax[j] = Math.max(lineMax[j], grid[i][j]);
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += Math.min(lineMax[j], rowMax[i]) - grid[i][j];
            }
        }
        return total;
    }
}

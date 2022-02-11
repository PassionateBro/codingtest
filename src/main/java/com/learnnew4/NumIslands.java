package com.learnnew4;

/**
 * @describtion: 200. 岛屿数量
 * @author: CaiJm
 * @Date: 2022-02-08 13:37
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || dp[i][j] == 1) continue;
                if (grid[i][j] == '1') {
                    markBfs(grid, i, j, dp);
                    res++;
                }
            }
        }
        return res;
    }

    private void markBfs(char[][] grid, int x, int y, int[][] dp) {
        dp[x][y] = 1;
        if (grid[x][y] == '1') {
            if (x - 1 >= 0 && dp[x - 1][y] == 0) markBfs(grid, x - 1, y, dp);
            if (x + 1 < grid.length && dp[x + 1][y] == 0) markBfs(grid, x + 1, y, dp);
            if (y - 1 >= 0 && dp[x][y - 1] == 0) markBfs(grid, x, y - 1, dp);
            if (y + 1 < grid[0].length && dp[x][y + 1] == 0) markBfs(grid, x, y + 1, dp);
        }
    }
}

package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-08-04 9:44
 */
public class UniquePathsIII {
    int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        int beginX = 0, beginY = 0;
        int step = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    beginX = i;
                    beginY = j;
                } else {
                    if (grid[i][j] == 0) {
                        step++;
                    }
                }
            }
        }
        int[][] dp = new int[grid.length][grid[0].length];
        grid[beginX][beginY] = -1;
        return getNum(beginX, beginY, dp, grid, step);
    }

    private int getNum(int x, int y, int[][] dp, int[][] grid, int step) {
        int sum = 0;
        for (int i = 0; i < direct.length; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                // 非法方向
                continue;
            }
            // 找到终点算一条路径
            if (grid[newX][newY] == 2) {
                // 走完所有格子
                if (step == 0) {
                    sum++;
                }
                continue;
            }
            // 该路径已经找寻过不通
            if (grid[newX][newY] == -1) {
                continue;
            }
            if (grid[newX][newY] == 0) {
                grid[newX][newY] = -1;
                int temp = getNum(newX, newY, dp, grid, step - 1);
                if (temp > 0) {
                    sum += temp;
                }
                grid[newX][newY] = 0;
            }
        }
        dp[x][y] = sum;
        return sum;
    }
}

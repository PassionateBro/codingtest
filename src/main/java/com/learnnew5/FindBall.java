package com.learnnew5;

/**
 * @describtion: 1706. 球会落何处
 * @author: CaiJm
 * @Date: 2022-02-24 10:27
 */
public class FindBall {
    public int[] findBall(int[][] grid) {
        int[] ints = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ints[i] = dfs(grid, 0, i, true);
        }
        return ints;
    }

    private int dfs(int[][] grid, int x, int y, boolean judgeX) {
        if (judgeX) {
            if (grid[x][y] == 1) {
                if (y + 1 < grid[0].length) {
                    if (grid[x][y + 1] == -1) return -1;
                    return dfs(grid, x, y + 1, false);
                }
            } else {
                if (y - 1 >= 0) {
                    if (grid[x][y - 1] == 1) return -1;
                    return dfs(grid, x, y - 1, !judgeX);
                }
            }
        } else {
            if (x + 1 == grid.length) {
                return y;
            }
            return dfs(grid, x + 1, y, true);
        }
        return -1;
    }
}

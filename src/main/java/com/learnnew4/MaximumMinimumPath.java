package com.learnnew4;

import java.util.PriorityQueue;

/**
 * @describtion: 1102. 得分最高的路径
 * @author: CaiJm
 * @Date: 2022-01-25 10:26
 */
public class MaximumMinimumPath {
    private PriorityQueue<Integer> queue;
    int[] left = {0, -1};
    int[] right = {0, 1};
    int[] up = {-1, 0};
    int[] down = {1, 0};

    public int maximumMinimumPath(int[][] grid) {
        queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[][] visited = new int[grid.length][grid[0].length];
        findNext(grid, visited, 0, 0, grid[0][0]);
        return queue.poll();
    }

    private void findNext(int[][] grid, int[][] visited, int i, int j, int score) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            queue.offer(Math.min(score, grid[i][j]));
            return;
        }
        int[] target = null;
        int value = 0;
        int nowMin = Math.min(score, grid[i][j]);
        if (i - 1 >= 0 && visited[i - 1][j] == 0) {
            if (grid[i - 1][j] > value) {
                value = grid[i - 1][j];
                target = up;
            }
        }
        if (i + 1 < visited.length && visited[i + 1][j] == 0) {
            if (grid[i + 1][j] > value) {
                value = grid[i + 1][j];
                target = down;
            }
        }
        if (j - 1 >= 0 && visited[i][j - 1] == 0) {
            if (grid[i][j - 1] > value) {
                value = grid[i][j - 1];
                target = left;
            }
        }

        if (j + 1 < visited[0].length && visited[i][j + 1] == 0) {
            if (grid[i][j + 1] > value) {
                value = grid[i][j + 1];
                target = right;
            }
        }
        if (target == null) return;
        int m = i + target[0];
        int n = j + target[1];
        visited[m][n] = 1;
        findNext(grid, visited, m, n, nowMin);
    }
}

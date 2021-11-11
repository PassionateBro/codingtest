package com.learn2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @describtion: 407. 接雨水 II
 * @author: CaiJm
 * @Date: 2021-11-03 9:16
 */
public class TrapRainWater {
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int trapRainWater(int[][] height) {
        int m = height.length, n = height[0].length, res = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> height[p[0]][p[1]]));
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
            queue.offer(new int[]{i, n - 1});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            queue.offer(new int[]{0, j});
            queue.offer(new int[]{m - 1, j});
            visited[0][j] = visited[m - 1][j] = true;
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int h = height[p[0]][p[1]];
            for (int[] d : DIRECTIONS) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                if (h > height[x][y]) {
                    res += h - height[x][y];
                    height[x][y] = h;
                }
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return res;
    }

}

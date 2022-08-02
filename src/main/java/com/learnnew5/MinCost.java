package com.learnnew5;

import java.util.LinkedList;

/**
 * @describtion: 1368. 使网格图至少有一条有效路径的最小代价
 * @author: CaiJm
 * @Date: 2022-03-17 14:51
 */
public class MinCost {
    static int[][] direction = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int minCost(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        // x, y, switchTime, roadTimes
        int[][] visited = new int[grid.length][grid[0].length];
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.pollFirst();
            int x = poll[0], y = poll[1];
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return poll[2];
            }
            visited[x][y] = 1;
            // 能走就一直走
            for (int i = 0; i < direction.length; i++) {
                int mX = direction[i][0] + x;
                int mY = direction[i][1] + y;
                if (mX >= 0 && mX < grid.length && mY >= 0 && mY < grid[0].length && visited[mX][mY] == 0) {
                    if (i == grid[x][y]) {
                        queue.addFirst(new int[]{mX, mY, poll[2]});
                    } else {
                        queue.addLast(new int[]{mX, mY, poll[2] + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        minCost(new int[][]{{2, 2, 2}, {2, 2, 2}});
    }

}

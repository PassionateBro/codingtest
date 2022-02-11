package com.learnnew4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-10 9:33
 */
public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int count = 0;
        //起点
        if (grid[0][0] == 0) queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //弹出此层的点
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                //是否到达终点
                if (point[0] == row - 1 && point[1] == col - 1) return count + 1;
                // visited[point[0]][point[1]] = true;
                //将此点的下一步全部加入队列
                for (int j = 0; j < 8; j++) {
                    int x = point[0] + direction[j][0];
                    int y = point[1] + direction[j][1];
                    //判断是否是有效点、
                    if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || grid[x][y] == 1) {
                        continue;
                    } else {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

}

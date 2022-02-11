package com.learnnew4;

/**
 * @describtion: 剑指 Offer 13. 机器人的运动范围
 * @author: CaiJm
 * @Date: 2022-02-10 15:54
 */
public class MovingCount {
    int res = 0;
    int[][] direct = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        bfs(visited, 0, 0, k);
        return res;
    }

    private void bfs(int[][] visited, int m, int n, int k) {
        if (visited[m][n] == 0) {
            visited[m][n] = 1;
            if (calculate(m, n) <= k) {
                res++;
                for (int[] p : direct) {
                    int x = p[0] + m, y = p[1] + n;
                    if (x >= 0 && x < visited.length && y >= 0 && y < visited[0].length) {
                        bfs(visited, x, y, k);
                    }
                }
            }
        }
    }

    private int calculate(int m, int n) {
        return (m / 10) + (m % 10) + (n / 10) + (n % 10);
    }

    public static void main(String[] args) {
        MovingCount ad = new MovingCount();
        ad.movingCount(11, 8, 16);
    }
}

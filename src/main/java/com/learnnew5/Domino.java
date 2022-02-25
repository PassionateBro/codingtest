package com.learnnew5;

/**
 * @describtion: LCP 04. 覆盖
 * @author: CaiJm
 * @Date: 2022-02-17 11:17
 */
public class Domino {
    int[][] direction = new int[][]{{0, 1}, {1, 0}};
    int x = 0;

    public int domino(int n, int m, int[][] broken) {
        int[][] dp = new int[n][m];
        if (broken.length > 0) {
            for (int i = 0; i < broken.length; i++) {
                dp[broken[i][0]][broken[i][1]] = 1;
            }
        }
        dfs(dp, 0, 0, 0);
        return x;
    }

    private void dfs(int[][] dp, int a, int b, int res) {
        if (a >= dp.length) {
            x = Math.max(x, res);
            return;
        }
        int times = 0;
        if (dp[a][b] == 0) {
            for (int k = 0; k < direction.length; k++) {
                int x = a + direction[k][0];
                int y = b + direction[k][1];
                if (x >= 0 && x < dp.length && y >= 0 && y < dp[0].length && dp[x][y] == 0) {
                    dp[a][b] = 1;
                    dp[x][y] = 1;
                    times++;
                    if (b < dp[0].length - 1) {
                        dfs(dp, a, b + 1, res + 1);
                    } else {
                        dfs(dp, a + 1, 0, res + 1);
                    }
                    dp[a][b] = 0;
                    dp[x][y] = 0;
                }
            }
        }
        if (times == 0) {
            if (b < dp[0].length - 1) {
                dfs(dp, a, b + 1, res);
            } else {
                dfs(dp, a + 1, 0, res);
            }
        }
    }

    public static void main(String[] args) {
        Domino domino = new Domino();
        domino.domino(4, 4, new int[][]{});
    }

}

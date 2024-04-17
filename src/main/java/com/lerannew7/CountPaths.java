package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-05 10:27
 */
public class CountPaths {
    public static int countPaths(int n, int[][] roads) {
        if (n == 1) {
            return 1;
        }
        int[][] r = new int[n][n];
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            r[a][b] = roads[i][2];
            r[b][a] = roads[i][2];
        }
        long[][] p = new long[n][2];
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            long nums = 0;
            // 计算从0跳跃的路径
            if (r[0][i] > 0) {
                min = r[0][i] % 1000000007;
                nums = 1;
            }
            // i > 1计算连续路径
            if (p[i - 1][0] > 0 && r[i - 1][i] > 0 && i > 1) {
                long road = ((p[i - 1][1] % 1000000007) + (r[i - 1][i] % 1000000007)) % 1000000007;
                if (road < min) {
                    min = road;
                    nums = p[i - 1][0];
                } else if (road == min) {
                    nums = ((nums % 1000000007) + (p[i - 1][0] % 1000000007)) % 1000000007;
                }
            }
            // 计算其他跳跃路径
            if (p[i][0] > 0 && i > 1) {
                if (p[i][1] < min) {
                    nums = p[i][0];
                    min = p[i][1];
                } else if (p[i][1] == min) {
                    nums = ((nums % 1000000007) + (p[i][0] % 1000000007)) % 1000000007;
                }
            }
            // 每个点必然有路
            p[i][0] = nums;
            p[i][1] = min;
            // 往后进行p跳跃
            if (i + 2 < n) {
                for (int j = i + 2; j < n; j++) {
                    if (r[i][j] > 0) {
                        long roadLen = ((p[i][1] % 1000000007) + (r[i][j] % 1000000007)) % 1000000007;
                        if (p[j][1] == 0 || roadLen < p[j][1]) {
                            p[j][0] = p[i][0];
                            p[j][1] = roadLen;
                        } else if (roadLen == p[j][1]) {
                            p[j][0] = ((p[j][0] % 1000000007) + (p[i][0] % 1000000007)) % 1000000007;
                        }
                    }
                }
            }
        }
        return (int) (p[n - 1][0] % 1000000007);
    }



    public static void main(String[] args) {
        int[][] a = {{3, 0, 4}, {0, 2, 3}, {1, 2, 2}, {4, 1, 3}, {2, 5, 5}, {2, 3, 1}, {0, 4, 1}, {2, 4, 6}, {4, 3, 1}};
        System.out.println(countPaths(6, a));
    }


}

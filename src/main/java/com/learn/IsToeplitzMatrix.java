package com.learn;

/**
 * @describtion: 766. 托普利茨矩阵
 * @author: CaiJm
 * @Date: 2021-09-17 9:34
 */
public class IsToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = m - 1; i > 0; i--) {
            int judge = matrix[n - 1][i];
            int y = n - 2;
            int x = i - 1;
            while (y >= 0 && x >= 0) {
                if (matrix[y][x] != judge) {
                    return false;
                }
                y--;
                x--;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            int judge = matrix[i][m - 1];
            int y = i - 1;
            int x = m - 2;
            while (y >= 0 && x >= 0) {
                if (matrix[y][x] != judge) {
                    return false;
                }
                y--;
                x--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }
}

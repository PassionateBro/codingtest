package com.learn;

/**
 * @describtion: 240. 搜索二维矩阵 II
 * @author: CaiJm
 * @Date: 2021-10-25 9:47
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (target == matrix[i][w - 1]) return true;
            if (target > matrix[i][w - 1]) continue;
            for (int j = w - 2; j >= 0; j--) {
                while (i < r - 1 && matrix[i][j] < target) {
                    i++;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        searchMatrix(ints, 20);
    }
}

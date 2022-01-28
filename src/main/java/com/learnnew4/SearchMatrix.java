package com.learnnew4;

/**
 * @describtion: 74. 搜索二维矩阵
 * @author: CaiJm
 * @Date: 2022-01-26 14:45
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int last = matrix[0].length - 1;
        int begin = 0, end = matrix.length - 1;
        int mid = 0;
        while (end - begin > 1) {
            mid = (begin + end) / 2;
            if (matrix[mid][last] == target) return true;
            if (matrix[mid][last] > target) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        if (matrix[begin][last] < target && matrix[end][last] >= target) {
            begin = end;
        }
        for (int i = 0; i <= last; i++) {
            if (target == matrix[begin][i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1}, {3}, {5}};
        searchMatrix(ints,3);
    }
}

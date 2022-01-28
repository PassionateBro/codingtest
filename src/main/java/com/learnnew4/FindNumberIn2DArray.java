package com.learnnew4;

/**
 * @describtion: 剑指 Offer 04. 二维数组中的查找
 * @author: CaiJm
 * @Date: 2022-01-27 14:02
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int last = matrix[0].length - 1;
        int begin = 0, end = matrix.length - 1;
        int mid = 0;
        while (end - begin > 1) {
            mid = (begin + end) / 2;
            if (matrix[mid][0] == target || matrix[mid][last] == target) return true;
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        if (matrix[end][0] <= target) begin = end;
        for (int i = 0; i <= last; i++) {
            if (matrix[begin][i] == target) return true;
            if (matrix[begin][i] > target) {
                if (i == 0) return false;
                while (begin > 0) {
                    if (matrix[begin][i] < target && i < last) {
                        i++;
                    } else {
                        begin--;
                    }
                    if (matrix[begin][i] == target) return true;
                }
                return false;
            }
        }
        return false;
    }
}

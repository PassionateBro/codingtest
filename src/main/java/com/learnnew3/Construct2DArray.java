package com.learnnew3;

/**
 * @describtion: 2022. 将一维数组转变成二维数组
 * @author: CaiJm
 * @Date: 2022-01-04 17:16
 */
public class Construct2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            int[] ints = new int[n];
            for (int j = 0; j < n; j++) {
                if (num >= original.length) return new int[0][0];
                ints[j] = original[num];
                num++;
            }
            res[i] = ints;
        }
        if (num != original.length) return new int[0][0];
        return res;
    }
}

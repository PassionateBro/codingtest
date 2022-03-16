package com.learnnew5;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-03-08 14:50
 */
public class FindPeakGrid {
    // 返回行最大值的列号
    public int maxOfRow(int[][] mat, int row) {
        if (row < 0 || row >= mat.length) {
            return -1;
        }
        int col = 0;
        for (int i = 1; i < mat[row].length; i++) {
            if (mat[row][i] > mat[row][col]) {
                col = i;
            }
        }
        return col;
    }

    public int[] findPeakGrid(int[][] mat) {
        int top = 0;
        int down = mat.length - 1;
        int mid;
        // m1 mid前一行最大值列号，m2:mid最大值列号，m3:mid+1行最大值列号
        int m1, m2, m3;
        int v1, v2, v3; //中间三行对应的最大值
        while (top <= down) {
            mid = (top + down) / 2;
            //System.out.printf("%d %d %d\n",top,mid,down);
            m2 = maxOfRow(mat, mid);
            if (top == down) {
                return new int[]{mid, m2};
            }
            m1 = maxOfRow(mat, mid - 1);
            m3 = maxOfRow(mat, mid + 1);

            v1 = mid - 1 >= 0 ? mat[mid - 1][m1] : -1;
            v2 = mat[mid][m2];
            v3 = mid + 1 < mat.length ? mat[mid + 1][m3] : -1;
            // 中间行最大，直接顶峰
            if (v2 > v3 && v2 > v1) {
                return new int[]{mid, m2};
            }
            // mid-1行最大
            if (v1 > v3 && v1 >= v2) {
                down = mid - 1;
            } else {
                // mid+1行最大
                top = mid + 1;
            }
        }
        return null;
    }
}

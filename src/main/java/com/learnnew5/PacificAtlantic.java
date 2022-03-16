package com.learnnew5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @describtion: 417. 太平洋大西洋水流问题
 * @author: CaiJm
 * @Date: 2022-03-15 10:13
 */
public class PacificAtlantic {
    int[][] flag = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] first = new boolean[m][n];
        boolean[][] second = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, first);
            dfs(matrix, i, n - 1, second);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, first);
            dfs(matrix, m - 1, i, second);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (first[i][j] && second[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    public void dfs(int[][] matrix, int i, int j, boolean[][] reach) {
        if (reach[i][j])
            return ;
        reach[i][j] = true;
        for (int m = 0; m < 4; m++) {
            int newX = i + flag[m][0], newY = j + flag[m][1];
            if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length
                    || matrix[i][j] > matrix[newX][newY] || reach[newX][newY])
                continue;
            dfs(matrix, newX, newY, reach);
        }
    }

    public static void main(String[] args) {
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        pacificAtlantic.pacificAtlantic(new int[][]{{1, 1}, {1, 1},{1, 1}});
    }
}

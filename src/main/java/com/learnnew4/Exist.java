package com.learnnew4;

/**
 * @describtion: 剑指 Offer 12. 矩阵中的路径
 * @author: CaiJm
 * @Date: 2022-02-10 15:27
 */
public class Exist {
    int[][] direct = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = 1;
                if (dfs(board, words, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int m, int n, int[][] visited) {
        if (idx == words.length - 1) {
            if (board[m][n] == words[idx]) {
                return true;
            } else {
                return false;
            }
        }
        if (board[m][n] != words[idx]) {
            return false;
        }
        for (int[] p : direct) {
            int x = m + p[0], y = n + p[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && visited[x][y] == 0) {
                visited[x][y] = 1;
                if (dfs(board, words, idx + 1, x, y, visited)) {
                    return true;
                }
                visited[x][y] = 0;
            }
        }
        return false;
    }
}

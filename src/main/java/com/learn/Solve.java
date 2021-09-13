package com.learn;

/**
 * @describtion: 130. 被围绕的区域
 * @author: CaiJm
 * @Date: 2021-09-02 10:24
 */
public class Solve {
    int x,y;
    public void solve(char[][] board) {
         x = board.length;
         y = board[0].length;
        for (int i = 0; i < x; i++) {
            dfs(board, i, 0);
            dfs(board, i, y - 1);
        }
        for (int i = 1; i < y - 1; i++) {
            dfs(board, 0, i);
            dfs(board, x - 1, i);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int n, int m) {
        if (n < 0 || n >= x || m < 0 || m >= y || board[n][m] != 'O') {
            return;
        }
        board[n][m] = 'A';
        dfs(board, n + 1, m);
        dfs(board, n - 1, m);
        dfs(board, n, m + 1);
        dfs(board, n, m - 1);
    }

}

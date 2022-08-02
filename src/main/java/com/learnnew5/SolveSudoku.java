package com.learnnew5;

/**
 * @describtion: 37. 解数独
 * @author: CaiJm
 * @Date: 2022-03-28 15:20
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        int[][] line = new int[9][10];
        int[][] row = new int[9][10];
        int[][] squart = new int[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int sqa = (i / 3) * 3 + ((j / 3) + 1);
                    line[i][board[i][j] - '0'] = 1;
                    row[j][board[i][j] - '0'] = 1;
                    squart[sqa][board[i][j] - '0'] = 1;
                }
            }
        }
        bfs(line, row, squart, board, 0, 0);
    }

    private boolean bfs(int[][] line, int[][] row, int[][] squart, char[][] board, int x, int y) {
        if (x >= 9) {
            return true;
        }
        int sqa = (x / 3) * 3 + ((y / 3) + 1);
        if (board[x][y] != '.') {
            line[x][board[x][y] - '0'] = 1;
            row[y][board[x][y] - '0'] = 1;
            squart[sqa][board[x][y] - '0'] = 1;
            if (y < 8) {
                return bfs(line, row, squart, board, x, y + 1);
            } else {
                return bfs(line, row, squart, board, x + 1, 0);
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (line[x][i] == 1 || row[y][i] == 1 || squart[sqa][i] == 1) {
                continue;
            }
            line[x][i] = 1;
            row[y][i] = 1;
            squart[sqa][i] = 1;
            boolean res = false;
            if (y < 8) {
                res = bfs(line, row, squart, board, x, y + 1);
            } else {
                res = bfs(line, row, squart, board, x + 1, 0);
            }
            if (res) {
                board[x][y] = (char) ('0' + i);
                return true;
            }
            line[x][i] = 0;
            row[y][i] = 0;
            squart[sqa][i] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] c = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(c);
    }
}

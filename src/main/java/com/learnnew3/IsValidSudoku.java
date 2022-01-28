package com.learnnew3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @describtion: 36. 有效的数独
 * @author: CaiJm
 * @Date: 2022-01-07 16:52
 */
public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> line = new HashMap<>();
        HashMap<String, HashSet<Integer>> squar = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            HashSet<Integer> set = row.get(i);
            if (set == null) {
                set = new HashSet<>();
                row.put(i, set);
            }
            for (int j = 0; j < board[0].length; j++) {
                char a = board[i][j];
                if (a == '.') continue;
                int num = a - 48;
                if (set.contains(num)) {
                    return false;
                }
                HashSet<Integer> lineSet = line.get(j);
                if (lineSet == null) {
                    lineSet = new HashSet<>();
                    line.put(j, lineSet);
                }
                if (lineSet.contains(num)) {
                    return false;
                }
                String s = (i/3) + "" + (j/3);
                HashSet<Integer> sqSet = squar.get(s);
                if (sqSet == null) {
                    sqSet = new HashSet<>();
                    squar.put(s, sqSet);
                }
                if (sqSet.contains(num)) {
                    return false;
                }
                set.add(num);
                lineSet.add(num);
                sqSet.add(num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        isValidSudoku(chars);
    }

}

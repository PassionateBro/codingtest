package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-11 14:24
 */
public class LetterCombinations {
    char[][] dp = new char[][]{{}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        ArrayList<String> objects = new ArrayList<>();
        dfs(chars, dp, 0, "", objects);
        return objects;
    }

    private void dfs(char[] table, char[][] dp, int tableIdx, String s, List<String> res) {
        if (tableIdx >= table.length) {
            res.add(s);
            return;
        }
        int i = table[tableIdx] - '1';
        for (int j = 0; j < dp[i].length; j++) {
            s += dp[i][j];
            dfs(table, dp, tableIdx + 1, s, res);
            s = s.substring(0, s.length() - 1);
        }
    }
}

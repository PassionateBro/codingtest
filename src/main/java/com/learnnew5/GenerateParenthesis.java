package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 22. 括号生成
 * @author: CaiJm
 * @Date: 2022-02-11 15:53
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> objects = new ArrayList<>();
        dfs(n, n, new StringBuilder(), objects);
        return objects;
    }

    private void dfs(int left, int right, StringBuilder s, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s.toString());
            return;
        }
        int tempLeft = left;
        for (int i = 0; i < left; i++) {
            s.append('(');
            tempLeft--;
            int tempRight = right;
            for (int j = 0; j < right - tempLeft; j++) {
                s.append(')');
                tempRight--;
                dfs(tempLeft, tempRight, s, res);
            }
            s.delete(s.length() - right + tempLeft, s.length());
        }
        s.delete(s.length() - left, s.length());
    }

    public static void main(String[] args) {
        GenerateParenthesis s = new GenerateParenthesis();
        s.generateParenthesis(2);
    }
}

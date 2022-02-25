package com.learnnew5;

import java.util.ArrayList;

/**
 * @describtion: 剑指 Offer 38. 字符串的排列
 * @author: CaiJm
 * @Date: 2022-02-22 13:36
 */
public class Permutation {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        int[] dp = new int[chars.length];
        dfs(chars, list, dp, new StringBuilder());
        return list.toArray(new String[list.size()]);
    }

    private void dfs(char[] chars, ArrayList<String> list, int[] dp, StringBuilder s) {
        if (s.length() == chars.length) {
            list.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (dp[i] == 1) continue;
            if (i > 0 && chars[i] == chars[i - 1] && dp[i - 1] == 0) continue;
            s.append(chars[i]);
            dp[i] = 1;
            dfs(chars, list, dp, s);
            s.deleteCharAt(s.length() - 1);
            dp[i] = 0;
        }
    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        int backIdx = res.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (judgeChar(chars[i])) {
                while (!judgeChar(chars[backIdx])) {
                    backIdx--;
                }
                res[i] = chars[backIdx];
                backIdx--;
            } else {
                res[i] = chars[i];
            }
        }
        return new String(res);
    }

    private boolean judgeChar(char c) {
        Integer va = Integer.valueOf(c);
        return (va >= 97 && va <= 122) || (va >= 65 && va <= 90);
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        Permutation permutation = new Permutation();
        permutation.reverseOnlyLetters(s);
    }

}

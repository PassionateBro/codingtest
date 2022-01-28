package com.learnnew3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @describtion: 139. 单词拆分
 * @author: CaiJm
 * @Date: 2022-01-21 11:17
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s= "leetcode";
        ArrayList<String> objects = new ArrayList<>();
        objects.add("leet");
        objects.add("code");
        wordBreak(s,objects);
    }
}

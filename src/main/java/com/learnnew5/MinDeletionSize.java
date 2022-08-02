package com.learnnew5;

import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-05-12 15:47
 */
public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int[] dp = new int[1000];
        HashSet<Integer> set = new HashSet();
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                if (set.contains(j)) {
                    continue;
                }
                if (dp[j] > cs[j]) {
                    set.add(j);
                    res++;
                }
                dp[j] = cs[j];
            }
        }
        return res;
    }
}

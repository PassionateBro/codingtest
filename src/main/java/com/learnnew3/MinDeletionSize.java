package com.learnnew3;

/**
 * @describtion: 944. 删列造序
 * @author: CaiJm
 * @Date: 2022-01-21 14:16
 */
public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 0) return 0;
        int res = 0;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                char judge = strs[j].charAt(i);
                if (judge - temp < 0) {
                    res++;
                    break;
                }
                temp = judge;
            }
        }
        return res;
    }
}

package com.learn2;

/**
 * @describtion: 1816. 截断句子
 * @author: CaiJm
 * @Date: 2021-12-06 9:10
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        if (s.length() == 0) return "";
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') k--;
            idx++;
            if (k == 0) break;
        }
        return s.substring(0, idx - (1 - k));
    }
}

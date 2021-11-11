package com.learn2;

/**
 * @describtion: 1974. 使用特殊打字机键入单词的最少时间
 * @author: CaiJm
 * @Date: 2021-11-11 9:41
 */
public class MinTimeToType {
    public int minTimeToType(String word) {
        int step = 0;
        char temp = 'a';
        for (char c : word.toCharArray()) {
            if (Math.abs(c - temp) <= 13) {
                step += Math.abs(c - temp) + 1;
            } else {
                step += (26 - Math.abs(c - temp)) + 1;
            }
            temp = c;
        }
        return step;
    }
}

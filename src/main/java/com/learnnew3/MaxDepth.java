package com.learnnew3;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-07 9:27
 */
public class MaxDepth {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int sum = 0;
        for (char c : chars) {
            if (c == '(') {
                sum++;
            }
            if (c == ')') {
                sum--;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}

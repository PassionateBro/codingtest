package com.learnnew5;

import java.util.Arrays;

/**
 * @describtion: 2055. 蜡烛之间的盘子
 * @author: CaiJm
 * @Date: 2022-03-08 10:12
 */
public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int[] candleLeft = new int[chars.length];
        Arrays.fill(candleLeft, -1);
        candleLeft[0] = chars[0] == '*' ? -1 : 0;
        for (int i = 1; i < dp.length; i++) {
            if (chars[i] == '*') {
                dp[i] = dp[i - 1] + 1;
                candleLeft[i] = candleLeft[i - 1];
            } else {
                dp[i] = dp[i - 1];
                candleLeft[i] = i;
            }
        }
        int[] candleRight = new int[chars.length];
        Arrays.fill(candleRight, -1);
        candleRight[candleRight.length - 1] = chars[dp.length - 1] == '*' ? -1 : dp.length - 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if (chars[i] == '*') {
                candleRight[i] = candleRight[i + 1];
            } else {
                candleRight[i] = i;
            }
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int left = candleRight[query[0]], right = candleLeft[query[1]];
            if (left == -1 || right == -1 || left >= right) {
                res[i] = 0;
            } else {
                res[i] = dp[right] - dp[left];
            }
            i++;
        }
        return res;
    }
}

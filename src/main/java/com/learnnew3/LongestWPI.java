package com.learnnew3;

/**
 * @describtion: 1124. 表现良好的最长时间段
 * @author: CaiJm
 * @Date: 2022-01-07 17:14
 */
public class LongestWPI {
    public static int longestWPI(int[] hours) {
        //min[i]表示的是前缀和为-i的对应的hours的最小角标
        int min[] = new int[hours.length + 5];
        for (int i = 0; i < min.length; i++) {
            min[i] = hours.length + 5;
        }
        int pre = 0, ans = 0;
        for (int i = 0; i < hours.length; i++) {
            pre += hours[i] > 8 ? 1 : -1;
            if (pre > 0) {
                ans = i + 1;
            } else {
                ans = Math.max(ans, i - min[-pre + 1]);
                min[-pre] = Math.min(min[-pre], i);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        longestWPI(new int[]{6, 9, 9});
    }
}

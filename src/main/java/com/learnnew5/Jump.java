package com.learnnew5;

/**
 * @describtion: 45. 跳跃游戏 II
 * @author: CaiJm
 * @Date: 2022-02-28 14:19
 */
public class Jump {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int i = 0;
        int step = 0;
        while (i < nums.length - 1) {
            if (nums[i] == 0) break;
            int nextIdx = 0;
            for (int j = 1; j <= nums[i]; j++) {
                int idx = i + j;
                int temp = idx;
                if (idx == nums.length - 1) return step + 1;
                if (idx < nums.length) {
                    temp = i + j + nums[i + j];
                }
                if (temp < nextIdx) continue;
                if (temp >= nextIdx) {
                    nextIdx = temp;
                    dp[i] = j + i;
                }
            }
            i = dp[i];
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
    }
}

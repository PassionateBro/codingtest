package com.dongtaiguihua;

/**
 * @describtion: 718. 最长重复子数组
 * @author: CaiJm
 * @Date: 2021-08-25 17:20
 */
public class FindLength {
    public static int findLength(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int len2 = nums2.length;
        int max = 0;
        int dp[][] = new int[len + 1][len2 + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}

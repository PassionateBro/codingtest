package com.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @describtion: 496. 下一个更大元素 I
 * @author: CaiJm
 * @Date: 2021-10-26 9:15
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int a = nums1.length, b = nums2.length;
        int[] dp = new int[b];
        Arrays.fill(dp, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[b - 1], b - 1);
        for (int i = b - 2; i >= 0; i--) {
            map.put(nums2[i], i);
            if (nums2[i] < nums2[i + 1]) {
                dp[i] = i + 1;
            } else {
                for (int j = i + 1; j < b; j++) {
                    if (dp[j] > 0 && nums2[i] < nums2[dp[j]]) {
                        dp[i] = dp[j];
                        break;
                    }
                }
            }
        }
        int[] ints = new int[a];
        for (int i = 0; i < a; i++) {
            int c = dp[map.get(nums1[i])];
            if (c == -1) {
                ints[i] = -1;
            } else {
                ints[i] = nums2[c];
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }
}

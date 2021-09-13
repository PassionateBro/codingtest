package com.learn;

import java.util.Arrays;

/**
 * @describtion: 1552. 两球之间的磁力
 * @author: CaiJm
 * @Date: 2021-09-02 9:04
 */
public class MaxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int[] position, int m) {
        int len = position.length;
        int num = 1;
        int pre = position[0];
        for (int i = 1; i < len; i++) {
            if (position[i] - pre >= mid) {
                num++;
                pre = position[i];
            }
        }
        return num >= m;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDistance().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
    }
}

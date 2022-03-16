package com.learnnew5;

/**
 * @describtion: 1231. 分享巧克力
 * @author: CaiJm
 * @Date: 2022-03-09 10:57
 * mark
 */
public class MaximizeSweetness {
    public int maximizeSweetness(int[] sweetness, int k) {
        long left = 1, right = (long)1e9 + 1;

        while (left < right) {
            long mid = (right - left) / 2 + left;
            if (check(sweetness, k + 1, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int)left - 1;
    }

    private boolean check(int[] arr, int k, long min) {
        int sum = 0, cnt = 0;

        for (int x : arr) {
            sum += x;
            if (sum >= min) {
                sum = 0;
                cnt++;
            }
        }

        return cnt >= k;
    }
}

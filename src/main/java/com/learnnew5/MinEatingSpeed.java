package com.learnnew5;

/**
 * @describtion: 875. 爱吃香蕉的珂珂
 * @author: CaiJm
 * @Date: 2022-06-07 15:14
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int x : piles) {
            max = Math.max(x, max);
        }
        int left = 1, right = max;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (judge(piles, h, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (judge(piles, h, left)) {
            return left;
        }
        return left + 1;
    }

    private boolean judge(int[] piles, int h, int x) {
        int count = 0;
        for (int n : piles) {
            if (n <= x) {
                count ++;
                continue;
            }
            int last = n % x;
            count += (n / x) + (last == 0 ? 0 : 1);
        }
        return count <= h;
    }

    public static void main(String[] args) {
        MinEatingSpeed A = new MinEatingSpeed();
        A.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
    }
}

package com.learn2;

/**
 * @describtion: 367. 有效的完全平方数
 * @author: CaiJm
 * @Date: 2021-11-04 9:12
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num >> 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            long val = (long) mid * mid;
            if (val > num) {
                right = mid - 1;
            } else if (val < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

package com.learn;

/**
 * @describtion: 878. 第 N 个神奇数字
 * @author: CaiJm
 * @Date: 2021-09-28 9:46
 */
public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        long LCM = LCM(a, b);
        long low = 1, high = Long.MAX_VALUE;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid / a + mid / b - mid / LCM < n) low = mid + 1;
            else high = mid - 1;
        }
        return (int) (low % 1000000007);
    }

    // 最小公倍数
    long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }

    // 最大公约数
    long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}

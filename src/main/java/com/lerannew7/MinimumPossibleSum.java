package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-08 9:51
 */
public class MinimumPossibleSum {
    static int mod = 1000000007;

    public static int minimumPossibleSum(int n, int target) {
        if (n == 1) {
            return 1;
        }
        int res = 0;
        int sub = 0;
        sub = target / 2;
        long a = Math.min(sub, n);
        res += (1 + a) * a / 2 % mod;
        if (a < n) {
            long last = target + n - a - 1;
            res = (int) ((res % mod) + ((target + last) * (last - target) / 2 % mod)) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        minimumPossibleSum(2,3);
    }


}

package com.learn;

/**
 * @describtion: 1922. 统计好数字的数目
 * @author: CaiJm
 * @Date: 2021-09-18 9:27
 */
public class CountGoodNumbers {
    public static int countGoodNumbers(long n) {
        long mod = 1000000007;
        long res = 1;
        long m, z;
        m = n / 2;
        long ans = 20;
        while (m > 0) {
            if ((m & 1) == 1) {
                res = ans * res % mod;
            }
            ans = ans * ans % mod;
            m = m >> 1;
        }
        if ((n & 1) == 1) {
            res = res * 5 % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(13));
        System.out.println(a(13));
    }

    public static int a(long n) {
        long results = 1;
        long mod = 1000000007;
        long ans = 20;
        long num = n / 2;
        while (num > 0) {
            if ((num & 1) != 0) {
                results = results * ans % mod;
            }
            ans = ans * ans % mod;
            num >>= 1;
        }

        if (n % 2 > 0) {
            results = results * 5 % mod;
        }

        return (int) results;
    }

}

package com.learn;

/**
 * @describtion: 1524. 和为奇数的子数组数目
 * @author: CaiJm
 * @Date: 2021-09-10 9:09
 */
public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr) {
        // num & 1 == 1 (即为奇数)
        int len = arr.length;
        int mod = 1000000007;
        int res = 0;
        int odd = 0, even = 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            res = (res + ((sum & 1) == 0 ? odd : even)) % mod;
            if ((sum & 1) == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return res;
    }
}

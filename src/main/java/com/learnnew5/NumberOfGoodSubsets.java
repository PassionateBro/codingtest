package com.learnnew5;

/**
 * @describtion: 1994. 好子集的数目
 * @author: CaiJm
 * @Date: 2022-02-22 9:25
 */
public class NumberOfGoodSubsets {

    private static final int mod = (int) 1e9 + 7;

    public int numberOfGoodSubsets(int[] nums) {
        //合数：6,10,14,15,21,22,26,30
        //质数：2,3,5,7,11,13,17,19,23,29；
        long count[] = new long[35];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        long ans = 0;
        long a = 1;
        //纯质数：
        a = a * (count[2] + 1) % mod;
        a = a * (count[3] + 1) % mod;
        a = a * (count[5] + 1) % mod;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a += mod - 1;
        ans = (ans + a) % mod;
        //6:
        a = 1;
        a = a * (count[5] + 1) % mod;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[6];
        ans = (ans + a) % mod;
        //10：
        a = 1;
        a = a * (count[3] + 1) % mod;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[10];
        ans = (ans + a) % mod;
        //14：
        a = 1;
        a = a * (count[3] + 1) % mod;
        a = a * (count[5] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[14];
        ans = (ans + a) % mod;
        //15：
        a = 1;
        a = a * (count[2] + 1) % mod;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[15];
        ans = (ans + a) % mod;
        //21：
        a = 1;
        a = a * (count[2] + 1) % mod;
        a = a * (count[5] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[21];
        ans = (ans + a) % mod;
        //22：
        a = 1;
        a = a * (count[3] + 1) % mod;
        a = a * (count[5] + 1) % mod;
        a = a * (count[7] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[22];
        ans = (ans + a) % mod;
        //26：
        a = 1;
        a = a * (count[3] + 1) % mod;
        a = a * (count[5] + 1) % mod;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[26];
        ans = (ans + a) % mod;
        //30：
        a = 1;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a *= count[30];
        ans = (ans + a) % mod;
        //合数：6,10,14,15,21,22,26,30
        //两数组合：10,21、14,15、15，22、15，26、21，22、21，26
        //10,21
        a = 1;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a = count[10] * count[21] % mod * a;
        ans = (ans + a) % mod;
        //14,15
        a = 1;
        a = a * (count[11] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a = count[14] * count[15] % mod * a;
        ans = (ans + a) % mod;
        //15,22
        a = 1;
        a = a * (count[7] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a = count[15] * count[22] % mod * a;
        ans = (ans + a) % mod;
        //15,26
        a = 1;
        a = a * (count[7] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a = count[15] * count[26] % mod * a;
        ans = (ans + a) % mod;
        //21,22
        a = 1;
        a = a * (count[5] + 1) % mod;
        a = a * (count[13] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a = count[21] * count[22] % mod * a;
        ans = (ans + a) % mod;
        //21,26
        a = 1;
        a = a * (count[5] + 1) % mod;
        a = a * (count[11] + 1) % mod;
        a = a * (count[17] + 1) % mod;
        a = a * (count[19] + 1) % mod;
        a = a * (count[23] + 1) % mod;
        a = a * (count[29] + 1) % mod;
        a = count[21] * count[26] % mod * a;
        ans = (ans + a) % mod;
        for (int i = 0; i < count[1]; i++) {
            ans = 2 * ans % mod;
        }
        return (int) ans;
    }


}

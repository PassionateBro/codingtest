package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-06 9:50
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        // 根据评论区可知（我没读懂题）丑数必是2 3 5的倍数
        int n2 = 0,n3 = 0,n5 = 0;
        int[] dp = new int[n];
        // 用于乘法，初始化是1
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            // 下一个2的倍数
            int a = 2 * dp[n2];
            // 3
            int b = 3 * dp[n3];
            // 5
            int c = 5 * dp[n5];
            // 哪个先出现本次循环就记录谁的倍数（下一个丑数）
            dp[i] = Math.min(a, Math.min(b, c));
            if(dp[i] == a) n2++;
            if(dp[i] == b) n3++;
            if(dp[i] == c) n5++;
        }
        return dp[n - 1];
    }
}

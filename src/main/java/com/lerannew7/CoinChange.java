package com.lerannew7;

import java.util.Arrays;

/**
 * @describtion: 322. 零钱兑换
 * @author: CaiJm
 * @Date: 2023-02-22 10:00
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount <= 0) return -1;
        int[] dp = new int[amount+1];//最多的硬币情况是全部是1元，共有amount个硬币，共有amount+1个状态，amount+1个金额
        Arrays.fill(dp, amount+1);//必须将所有的dp赋最大值，因为要找最小值
        dp[0] = 0;//自底向上，金额为0，最小硬币数为0
        for(int am = 1; am <= amount; am++){//自底向上
            for(int coin : coins){//遍历coins的金额
                if(am >= coin)//am-coin 必须大于0，否则数组溢出
                    dp[am] = Math.min(dp[am], dp[am-coin] + 1);//金额为11的最小硬币数 和 金额为(11-一个面值)的最小硬币数+1 比较最小值
            }
        }
        return dp[amount]>amount? -1: dp[amount];//返回金额为amount的最小硬币数 根据测试用例判断dp[amout]>amount
    }
}

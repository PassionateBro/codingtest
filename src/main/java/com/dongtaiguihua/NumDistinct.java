package com.dongtaiguihua;

import java.util.Arrays;

/**
 * @describtion: 115. 不同的子序列 t在s中出现的子序数
 * @author: CaiJm
 * @Date: 2021-08-26 13:44
 */
public class NumDistinct {
    public static int numDistinct(String s, String t) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1);
        int pre = 1;
        //每行算一次
        for(int i = 0; i < t.length(); i++){
            //0-n算n+1次
            for(int j = 0; j <= s.length(); j++){
                //先保存dp[j]下次用
                int temp = dp[j];
                if(j == 0){
                    dp[j] = 0;
                }else {
                    if(t.charAt(i) == s.charAt(j-1)){
                        dp[j] = dp[j-1] + pre;
                    }else {
                        dp[j] = dp[j-1];
                    }
                }
                pre = temp;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}

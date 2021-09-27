package com.work;

import cn.hutool.core.util.RandomUtil;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-09-07 15:42
 */
public class EggCodingV2 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] reward = getReward(1000, 800);
            System.out.println(Arrays.toString(reward));
            System.out.println(reward.length);
        }
    }


    public static int[] getReward(int joinNum, int rewardAmount) {
        int[] resArray = new int[rewardAmount + 1];
        // 取短的步长 保证奖品全部发完
        double h = new BigDecimal(joinNum).divide(new BigDecimal(rewardAmount), 2, BigDecimal.ROUND_DOWN).doubleValue();
        double left = 1.;
        double right = h;
        for (int i = 1; i <= rewardAmount; i++) {
            int max = (int) (right + 1);
            if (i == rewardAmount) {
                max = joinNum + 1;
            }
            int res = RandomUtil.randomInt((int) left, max);
            left = max;
            right = max + (h - (left - right));
            resArray[i] = res;
        }
        return resArray;
    }
}

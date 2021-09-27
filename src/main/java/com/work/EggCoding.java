package com.work;

import java.util.Arrays;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-09-06 14:00
 */
public class EggCoding {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] reward = getReward(17, 3);
            System.out.println(Arrays.toString(reward));
        }
    }

    public static int[] getReward(int joinNum, int rewardAmount) {
        int[] resArray = new int[joinNum + 1];
        int maxCommon = maxCommonDivisor(joinNum, rewardAmount);
        int x = joinNum / maxCommon;
        int y = rewardAmount / maxCommon;
        int count = x;
        int rewardLef = y;
        for (int i = 1; i <= joinNum; i++) {
            if (rewardLef > 0) {
                int res = 1;
                if (count > rewardLef) {
                    res = Math.random() < (rewardLef * 1.0 / count * 1.0) ? 1 : 0;
                }
                if (res == 1) {
                    rewardLef --;
                }
                resArray[i] = res;
            }
            count--;
            if (count == 0) {
                count = x;
                rewardLef = y;
            }
        }
        return resArray;
    }

    /**
     * 欧几里德算法得最大公约数
     *
     * @param m 参与人数
     * @param n 奖品数量
     * @return
     */
    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {     // 保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {  // 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;    // 返回最大公约数
    }
}

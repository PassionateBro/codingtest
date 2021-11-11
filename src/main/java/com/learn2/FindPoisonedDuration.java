package com.learn2;

/**
 * @describtion: 495. 提莫攻击
 * @author: CaiJm
 * @Date: 2021-11-10 9:05
 */
public class FindPoisonedDuration {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] >= timeSeries[i - 1] + duration) {
                res = res + duration;
            } else {
                res = res + (timeSeries[i] - timeSeries[i - 1]);
            }
        }

        return res + duration;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 2, 3, 4, 5}, 5));
    }
}

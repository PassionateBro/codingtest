package com.learn2;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-12-01 15:00
 */
public class MaxScore {
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int left = 0, right = len - k - 1;
        int min = 0;
        int sum = 0;
        int windowSum = 0;
        for (int i = 0; i < len; i++) {
            sum += cardPoints[i];
            if (i <= right) {
                windowSum += cardPoints[i];
            }
        }
        if (right < 0) return sum;
        min = windowSum;
        for (int i = right + 1; i < len; i++) {
            windowSum = windowSum - cardPoints[left] + cardPoints[i];
            left++;
            min = Math.min(windowSum, min);
        }
        return sum - min;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,1000,1}, 1));
    }

}

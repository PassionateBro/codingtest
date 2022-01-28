package com.learn2;

import java.util.HashSet;

/**
 * @describtion: 507. 完美数
 * @author: CaiJm
 * @Date: 2021-11-22 17:53
 */
public class CheckPerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;
        for (int i = 2, x = (int) Math.sqrt(num); i <= x; i++) {
            if (num % i == 0) {
                int temp = num / i;
                sum += i + temp;
            }
        }
        return num == sum;
    }

}

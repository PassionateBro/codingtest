package com.learn2;

import java.util.HashSet;

/**
 * @describtion: 507. 完美数
 * @author: CaiJm
 * @Date: 2021-11-22 17:53
 */
public class CheckPerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num <=1) return false;
        HashSet<Integer> set = new HashSet<>();
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                int temp = num / i;
                if (set.contains(temp)) break;
                sum += i + temp;
                set.add(i);
                set.add(temp);
            }
        }
        return num == sum;
    }

    public static void main(String[] args) {
        checkPerfectNumber(28);
    }
}

package com.learn;

/**
 * @describtion: 204. 计数质数
 * @author: CaiJm
 * @Date: 2021-10-15 9:40
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
                for (int j = i + i; j < n; j += i)
                    flag[j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10000));
    }
}

package com.learn;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-08-24 9:13
 */
public class ArrangeCoins {
    /**
     *
     */
    public static int solution(int n) {
        int i = 1;
        while(i <= n) {
            n = n - i;
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(8));
        System.out.println(solution(5));
    }
}

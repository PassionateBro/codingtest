package com.learn2;

/**
 * @describtion: 9. 回文数
 * @author: CaiJm
 * @Date: 2021-11-30 15:15
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        int y = x < 0 ? -x : x;
        int r, k = 0;
        while (y != 0) {
            k = k * 10 + y % 10;
            y /= 10;
        }
        return x == k;
    }

    public static void main(String[] args) {
        isPalindrome(1665661);
    }
}

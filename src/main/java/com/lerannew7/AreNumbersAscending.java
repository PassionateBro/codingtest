package com.lerannew7;

import java.util.Arrays;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-01-03 13:50
 */
public class AreNumbersAscending {
    public static boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int judge = -1;
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            if (s2.charAt(0) >= '0' && s2.charAt(0) <= '9') {
                int temp = Integer.valueOf(s2);
                if (judge < temp) {
                    judge = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
                areNumbersAscending(s);
                char b = '1';
        System.out.println(b - '0');
        int[] a = new int[b - '0'];
                a[0]= 1;
                a[1] = 2;
        int[] ints = Arrays.copyOf(a, 2);
        System.out.println(ints[1]);
    }
}

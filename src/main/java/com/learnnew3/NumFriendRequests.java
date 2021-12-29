package com.learnnew3;

import java.util.Arrays;

/**
 * @describtion: 825. 适龄的朋友
 * @author: CaiJm
 * @Date: 2021-12-27 13:34
 */
public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        int left = 0, right = 1;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < ages.length && ages[right + 1] <= age) {
                ++right;
            }
            res += right - left;
        }
        return res;
    }

    private int fact(int i, int res) {
        if (i == 1) {
            return res;
        } else {
            return fact(i - 1, res * i);
        }
    }

    public static void main(String[] args) {
        NumFriendRequests numFriendRequests = new NumFriendRequests();
        System.out.println(numFriendRequests.numFriendRequests(new int[]{56, 117, 42, 55, 100, 27, 97, 113, 56, 57, 117, 13, 42, 119, 67}));
    }
}

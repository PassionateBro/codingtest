package com.learn;

import java.util.Arrays;

/**
 * @describtion: 475. 供暖器
 * @author: CaiJm
 * @Date: 2021-09-24 10:22
 */
public class FindRadius {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int j = 0;
        if (heaters.length == 1) {
            for (int i = 0; i < houses.length; i++) {
                int a = Math.abs(heaters[j] - houses[i]);
                res = Math.max(a, res);
            }
            return res;
        }
        for (int i = 0; i < houses.length; i++) {
            while (j < heaters.length - 2) {
                if (heaters[j + 1] < houses[i]) {
                    j++;
                } else {
                    break;
                }
            }
            int a = Math.abs(heaters[j] - houses[i]);
            int b = Math.abs(heaters[j + 1] - houses[i]);
            if (a <= b) {
                res = Math.max(a, res);
            } else {
                res = Math.max(b, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999}, new int[]{499, 500, 501}));
    }
}

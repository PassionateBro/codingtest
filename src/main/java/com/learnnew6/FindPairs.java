package com.learnnew6;

import java.util.HashMap;
import java.util.Map;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-06-16 9:36
 */
public class FindPairs {
    public static int findPairs(int[] nums, int k) {
        if (k == 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int a : nums) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            }
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, 1);
        }
        int res = 0;
        for (int a : nums) {
            if (map.get(a) == 0) continue;
            if (map.containsKey(a + k)) {
                res++;
                map.put(a, map.get(a) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findPairs(new int[]{3, 1, 4, 1, 5}, 2);
    }
}

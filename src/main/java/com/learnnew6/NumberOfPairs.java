package com.learnnew6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-23 14:00
 */
public class NumberOfPairs {
    public static int numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        HashSet<String> rep = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (!rep.add(String.valueOf(nums[i]))) {
                continue;
            }
            char[] chars = String.valueOf(nums[i]).toCharArray();
            StringBuilder s = new StringBuilder();
            for (int j = chars.length - 1; j >= 0; j--) {
                if (s.length() == 0 && chars[j] == '0') continue;
                s.append(chars[j]);
            }
            rep.add(s.toString());
            int des = Math.abs(nums[i] - Integer.valueOf(s.toString()));
            map.put(des, map.getOrDefault(des, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if (ent.getValue() == 1) continue;
            int value = ent.getValue();
            if (value == 2) {
                res += 1;
                continue;
            }
            long temp = 1;
            for (int i = value; i >= 1; i--) {
                temp *= i;
            }
            res += temp / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        numberOfPairs(new int[]{0, 4, 5, 0, 2, 1, 6, 4, 3, 2, 2, 4, 3, 7, 6, 1, 4, 3, 4, 2});
    }
}

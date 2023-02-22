package com.learnnew6;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-23 14:24
 */
public class Intersection {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (en.getValue() == nums.length) {
                res.add(en.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }
}

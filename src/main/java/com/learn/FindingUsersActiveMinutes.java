package com.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @describtion: 1817. 查找用户活跃分钟数
 * @author: CaiJm
 * @Date: 2021-09-22 16:05
 */
public class FindingUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int min = logs[i][1];
            if (map.containsKey(id)) {
                map.get(id).add(min);
            } else {
                HashSet<Integer> objects = new HashSet<>();
                objects.add(min);
                map.put(id, objects);
            }
        }
        int[] res = new int[k];
        for (Set set: map.values()) {
            int size = set.size();
            res[size - 1] += 1;
        }
        return res;
    }
}

package com.learn;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @describtion: 1376. 通知所有员工所需的时间
 * @author: CaiJm
 * @Date: 2021-09-09 9:06
 */
public class NumOfMinutes {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int i = 0; i < manager.length; i++) {

                if (manager[i] == -1)
                    continue;

                if (!map.containsKey(manager[i]))
                    map.put(manager[i], new HashSet<>());

                map.get(manager[i]).add(i);
            }

            return dfs(map, informTime, headID, 0);
        }

        public int dfs(Map<Integer, Set<Integer>> map, int[] informTime, int cur, int sum) {

            if (!map.containsKey(cur))
                return sum;

            int max = 0;

            for (int next : map.get(cur))
                max = Math.max(max, dfs(map, informTime, next, sum + informTime[cur]));

            return max;
        }


    public static void main(String[] args) {
    }
}

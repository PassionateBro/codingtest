package com.learnnew4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @describtion: 1086. 前五科的均分
 * @author: CaiJm
 * @Date: 2022-02-07 14:41
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            PriorityQueue<Integer> queue = map.getOrDefault(items[i][0], new PriorityQueue<>((o1, o2) -> o2 - o1));
            queue.add(items[i][1]);
            map.put(items[i][0], queue);
        }
        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> value = entry.getValue();
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += value.poll();
            }
            res[idx] = new int[]{entry.getKey(), sum / 5};
            idx ++;
        }
        return res;
    }
}

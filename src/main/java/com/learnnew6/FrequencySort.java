package com.learnnew6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @describtion: 1636. 按照频率将数组升序排序
 * @author: CaiJm
 * @Date: 2022-09-19 9:37
 */
public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        int[] res = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> dequeue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] a = new int[]{entry.getKey(), entry.getValue()};
            dequeue.add(a);
        }
        int i = 0;
        while (!dequeue.isEmpty()) {
            int[] temp = dequeue.poll();
            for (int j = 0; j < temp[1]; j++) {
                res[i] = temp[0];
                i++;
            }
        }
        return res;
    }
}

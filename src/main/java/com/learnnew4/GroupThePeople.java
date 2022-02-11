package com.learnnew4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @describtion: 1282. 用户分组
 * @author: CaiJm
 * @Date: 2022-02-07 16:39
 */
public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList<List<Integer>> objects = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < groupSizes.length; i++) {
            queue.offer(new int[]{groupSizes[i], i});
        }
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            temp.add(poll[1]);
            if (temp.size() == poll[0]) {
                objects.add(temp);
                temp = new ArrayList<>();
            }
        }
        return objects;
    }
}

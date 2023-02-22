package com.learnnew6;

import java.util.*;

/**
 * @describtion: 1282. 用户分组
 * @author: CaiJm
 * @Date: 2022-08-12 9:47
 */
public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Queue<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            Queue<List<Integer>> queue = map.get(size);
            if (queue == null || queue.isEmpty()) {
                Queue<List<Integer>> newQ = new LinkedList<>();
                List<Integer> objects = new ArrayList<>();
                objects.add(i);
                if (objects.size() == size) {
                    res.add(objects);
                } else {
                    newQ.offer(objects);
                    map.put(size, newQ);
                }
            } else {
                List<Integer> poll = queue.poll();
                poll.add(i);
                if (poll.size() == size) {
                    res.add(poll);
                } else {
                    queue.offer(poll);
                }
            }
        }
        return res;
    }
}

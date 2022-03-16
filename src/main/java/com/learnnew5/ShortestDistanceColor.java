package com.learnnew5;

import java.util.*;

/**
 * @describtion: 1182. 与目标颜色间的最短距离
 * @author: CaiJm
 * @Date: 2022-03-09 11:20
 */
public class ShortestDistanceColor {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            if (!map.containsKey(colors[i])) {
                map.put(colors[i], new LinkedList<>());
            }
            map.get(colors[i]).addLast(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int number = queries[i][1];
            Deque<Integer> deque = map.get(number);
            if (deque == null) {
                res.add(-1);
                continue;
            }
            if (idx <= deque.peekFirst()) {
                res.add(deque.peekFirst() - idx);
            } else if (idx >= deque.peekLast()) {
                res.add(idx - deque.peekLast());
            } else {
                int left = idx;
                int right = idx;
                int temp = 1;
                while (true) {
                    if (left >= 0) {
                        if (colors[left] == number) {
                            res.add(idx - left);
                            break;
                        }
                        left--;
                    }
                    if (right <= colors.length - 1) {
                        if (colors[right] == number) {
                            res.add(right - idx);
                            break;
                        }
                        right++;
                    }
                }
            }
        }
        return res;
    }
}

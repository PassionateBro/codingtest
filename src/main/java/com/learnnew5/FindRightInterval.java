package com.learnnew5;

import java.util.TreeMap;

/**
 * @describtion: 436. 寻找右区间
 * @author: CaiJm
 * @Date: 2022-05-20 9:42
 */
public class FindRightInterval {
    static int max = Integer.MIN_VALUE;

    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (map.containsKey(interval[0])) {
                continue;
            }
            map.put(interval[0], i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            Integer integer = map.ceilingKey(interval[1]);
            if (integer != null) {
                res[i] = map.get(integer);
            } else {
                res[i] = -1;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}});
    }
}

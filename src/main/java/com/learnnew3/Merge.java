package com.learnnew3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @describtion: 56. 合并区间
 * @author: CaiJm
 * @Date: 2021-12-17 15:17
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int idx = 0;
        int begin = 0;
        int end = -1;
        while (idx <= intervals.length - 1) {
            int tempBegin = intervals[idx][0];
            int tempEnd = intervals[idx][1];
            if (end == -1) {
                begin = tempBegin;
                end = tempEnd;
                idx++;
                continue;
            }
            if (end < tempBegin) {
                list.add(new int[]{begin, end});
                begin = tempBegin;
            }
            end = Math.max(end, tempEnd);
            idx++;
        }
        if (end > -1) {
            list.add(new int[]{begin, end});
        }
        return list.toArray(new int[list.size()][2]);
    }
}

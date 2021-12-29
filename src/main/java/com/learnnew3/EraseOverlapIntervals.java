package com.learnnew3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @describtion: 435. 无重叠区间
 * @author: CaiJm
 * @Date: 2021-12-29 11:11
 */
public class EraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[] before = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            int[] after = intervals[i];
            if (after[0] < before[1]) {
                if (after[1] <= before[1]) {
                    before = after;
                }
                res++;
            } else {
                before = after;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        int i = eraseOverlapIntervals(ints);
    }
}

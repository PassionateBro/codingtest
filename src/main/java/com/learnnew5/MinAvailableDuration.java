package com.learnnew5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @describtion: 1229. 安排会议日程
 * @author: CaiJm
 * @Date: 2022-03-10 9:58
 */
public class MinAvailableDuration {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);
        int idx1 = 0, idx2 = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (idx1 < slots1.length && idx2 < slots2.length) {
            int begin1 = slots1[idx1][0], end1 = slots1[idx1][1];
            int begin2 = slots2[idx2][0], end2 = slots2[idx2][1];
            if (end1 <= begin2) {
                idx1++;
            } else if (end2 <= begin1) {
                idx2++;
            } else {
                if (begin1 <= begin2) {
                    if (end1 <= end2) {
                        int time = end1 - begin2;
                        if (time >= duration) {
                            res.add(begin2);
                            res.add(begin2 + duration);
                            return res;
                        } else {
                            idx1++;
                        }
                    } else {
                        int time = end2 - begin2;
                        if (time >= duration) {
                            res.add(begin2);
                            res.add(begin2 + duration);
                            return res;
                        } else {
                            idx2++;
                        }
                    }
                } else {
                    if (end2 <= end1) {
                        int time = end2 - begin1;
                        if (time >= duration) {
                            res.add(begin1);
                            res.add(begin1 + duration);
                            return res;
                        } else {
                            idx2++;
                        }
                    } else {
                        int time = end1 - begin1;
                        if (time >= duration) {
                            res.add(begin1);
                            res.add(begin1 + duration);
                            return res;
                        } else {
                            idx1++;
                        }
                    }
                }
            }
        }
        return res;
    }
}

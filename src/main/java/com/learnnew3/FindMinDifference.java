package com.learnnew3;

import java.util.Arrays;
import java.util.List;

/**
 * @describtion: 539. 最小时间差
 * @author: CaiJm
 * @Date: 2022-01-18 9:32
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            String[] split = timePoints.get(i).split(":");
            ints[i] = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        }
        Arrays.sort(ints);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < ints.length; i++) {
            min = Math.min(min, ints[i] - ints[i - 1]);
        }
        min = Math.min(min, ints[0] + 1440 - ints[ints.length - 1]);
        return min;
    }
}

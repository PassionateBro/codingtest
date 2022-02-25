package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @author: CaiJm
 * @Date: 2022-02-18 10:34
 */
public class FindContinuousSequence {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);

    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }
}

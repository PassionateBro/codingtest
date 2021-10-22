package com.learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 229. 求众数 II  这题可用摩尔投票法，非常有意思
 * @author: CaiJm
 * @Date: 2021-10-22 9:06
 */
public class MajorityElement {
    public static List<Integer> majorityElement(int[] nums) {
        int m = nums.length;
        LinkedList<Integer> objects = new LinkedList<>();
        Arrays.sort(nums);
        int k = nums[0];
        int j = 1;
        boolean judge = true;
        if (judge) {
            if (j * 3 > m) {
                objects.add(k);
                judge = false;
            }
        }
        for (int i = 1; i < m; i++) {
            if (nums[i] == k) {
                j++;
                if (judge) {
                    if (j * 3 > m) {
                        objects.add(k);
                        judge = false;
                    }
                }
            } else {
                k = nums[i];
                j = 1;
                judge = true;
            }
        }
        if (judge) {
            if (j * 3 > m) {
                objects.add(k);
                judge = false;
            }
        }
        return objects;
    }

    public static void main(String[] args) {
        majorityElement(new int[]{1, 2});
    }
}

package com.learnnew5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 78. 子集
 * @author: CaiJm
 * @Date: 2022-02-11 13:45
 */
public class Subsets {
    ArrayList<List<Integer>> objects;

    public List<List<Integer>> subsets(int[] nums) {
        objects = new ArrayList<>();
        if (nums.length > 0) {
            objects.add(new LinkedList<>());
        }
        dfs(nums, 0, new LinkedList<>());
        return objects;
    }

    private void dfs(int[] nums, int idx, LinkedList<Integer> list) {
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            list.addLast(nums[i]);
            objects.add(new ArrayList<>(list));
            dfs(nums, i + 1, list);
            list.pollLast();
        }
    }
}

package com.learnnew5;

import java.util.*;

/**
 * @describtion: 90. 子集 II
 * @author: CaiJm
 * @Date: 2022-02-11 13:55
 */
public class SubsetsWithDup {
    ArrayList<List<Integer>> objects;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        objects = new ArrayList<>();
        if (nums.length > 0) {
            objects.add(new LinkedList<>());
        }
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        dfs(nums, 0, new ArrayList<>(), set);
        return objects;
    }

    private void dfs(int[] nums, int idx, ArrayList<Integer> list, HashSet<ArrayList<Integer>> set) {
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            if (!set.contains(list)) {
                objects.add(new ArrayList<>(list));
                set.add(list);
            }
            dfs(nums, i + 1, list, set);
            list.remove(list.size() - 1);
        }
    }

}

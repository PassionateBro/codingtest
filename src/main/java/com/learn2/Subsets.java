package com.learn2;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

/**
 * @describtion: 剑指 Offer II 079. 所有子集
 * @author: CaiJm
 * @Date: 2021-11-30 15:24
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> objects = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(objects, nums, 0, list);
        return objects;
    }

    public static void dfs(List objects, int[] nums, int idx, LinkedList<Integer> member) {

        if (idx >= nums.length) {
            objects.add(member);
            return;
        }
        dfs(objects, nums, idx + 1, member);
        LinkedList<Integer> t = new LinkedList<>();
        t.addAll(member);
        t.add(nums[idx]);
        dfs(objects, nums, idx + 1, t);
    }
}

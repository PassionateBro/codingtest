package com.learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 47. 全排列 II
 * @author: CaiJm
 * @Date: 2021-09-24 16:50
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(res, nums, new LinkedList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, LinkedList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        permuteUnique.permuteUnique(new int[]{1, 1, 2});
    }
}

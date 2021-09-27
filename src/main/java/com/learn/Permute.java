package com.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 46. 全排列
 * @author: CaiJm
 * @Date: 2021-09-24 17:14
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        int[] visited = new int[nums.length];
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
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute a = new Permute();
        a.permute(new int[]{1,2,3});
    }
}

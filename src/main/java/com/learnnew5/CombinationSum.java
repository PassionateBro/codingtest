package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 39. 组合总和
 * @author: CaiJm
 * @Date: 2022-02-11 15:00
 */
public class CombinationSum {
    List<List<Integer>> res;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.target = target;
        for (int i = 0; i < candidates.length; i++) {
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(candidates[i]);
            bfs(candidates, candidates[i], i, objects);
        }
        return res;
    }

    private void bfs(int[] candidates, int now, int idx, List<Integer> list) {
        if (now > target) {
            return;
        }
        if (target == now) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx >= candidates.length) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            bfs(candidates, now + candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}

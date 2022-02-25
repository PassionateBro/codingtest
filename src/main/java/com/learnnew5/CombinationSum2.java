package com.learnnew5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-11 15:36
 */
public class CombinationSum2 {
    List<List<Integer>> res;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        this.target = target;
        for (int i = 0; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
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
        for (int i = idx + 1; i < candidates.length; i++) {
            if (candidates[i] == candidates[i - 1] && i != idx + 1) {
                continue;
            } else {
                list.add(candidates[i]);
                bfs(candidates, now + candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

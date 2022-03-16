package com.learnnew5;

/**
 * @describtion: 2044. 统计按位或能得到最大值的子集数目
 * @author: CaiJm
 * @Date: 2022-03-15 9:57
 */
public class CountMaxOrSubsets {
    int total = 0;

    public int countMaxOrSubsets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res |= nums[i];
        }
        bfs(nums, 0, 0, res);
        return total;
    }

    private void bfs(int[] nums, int idx, int or, int res) {
        if (idx >= nums.length) {
            if (or == res) {
                total++;
            }
            return;
        }
        bfs(nums, idx + 1, or | nums[idx], res);
        bfs(nums, idx + 1, or, res);
    }
}

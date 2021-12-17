package com.learn2;

/**
 * @describtion: 985. 查询后的偶数和
 * @author: CaiJm
 * @Date: 2021-12-17 9:59
 */
public class SumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                point += nums[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int before = nums[queries[i][1]];
            if (before % 2 == 0) point -= before;
            int after = queries[i][0] + before;
            nums[queries[i][1]] = after;
            if (after % 2 == 0) point += after;
            res[i] = point;
        }
        return res;
    }
}

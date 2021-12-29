package com.learnnew3;

/**
 * @describtion: 1995. 统计特殊四元组
 * @author: CaiJm
 * @Date: 2021-12-29 9:22
 */
public class CountQuadruplets {

    public int countQuadruplets(int[] nums) {
        int[] cnt = new int[301];
        int res = 0;
        for (int i = 2; i < nums.length; i++){
            res += cnt[nums[i]];
            for (int j = i - 1; j > 0; j--){
                for (int k = j - 1; k >= 0; k--){
                    cnt[nums[i] + nums[j] + nums[k]]++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountQuadruplets countQuadruplets = new CountQuadruplets();
        countQuadruplets.countQuadruplets(new int[]{1, 2, 3, 6});
    }

}

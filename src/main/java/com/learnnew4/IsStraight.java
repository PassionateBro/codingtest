package com.learnnew4;

/**
 * @describtion: 剑指 Offer 61. 扑克牌中的顺子
 * @author: CaiJm
 * @Date: 2022-02-10 17:07
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        int[] bucket=new int[14];
        int min=14,max=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) continue;
            //有非0的对子,直接false
            if(bucket[nums[i]]==1) return false;
            bucket[nums[i]]++;
            //记录牌面最大和最小
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        //小于等于4就行,少的用0补
        return max-min<=4;
    }
}

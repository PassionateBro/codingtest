package com.learn;

import java.util.HashSet;

/**
 * @describtion: 26. 删除有序数组中的重复项
 * @author: CaiJm
 * @Date: 2021-09-23 10:13
 */
public class RemoveDuplicates1 {
    public static int removeDuplicates(int[] nums) {
        // 使用双指针
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int i = 0,j =1;
        while(j<nums.length){
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{-3,-1,0,0}));
    }
}

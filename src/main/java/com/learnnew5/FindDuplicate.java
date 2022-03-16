package com.learnnew5;

/**
 * @describtion: 287. 寻找重复数
 * @author: CaiJm
 * @Date: 2022-03-10 10:18
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1^2);
        System.out.println(2^2);
    }
}

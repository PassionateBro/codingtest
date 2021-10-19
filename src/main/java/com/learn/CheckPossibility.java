package com.learn;

/**
 * @describtion: 665. 非递减数列
 * @author: CaiJm
 * @Date: 2021-10-15 13:50
 */
public class CheckPossibility {
    public static boolean checkPossibility(int[] nums) {
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (times == 0) return false;
                times--;
                if (i > 1) {
                    if (nums[i - 2] > nums[i]) nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

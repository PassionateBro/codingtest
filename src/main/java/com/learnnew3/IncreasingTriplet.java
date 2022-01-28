package com.learnnew3;

/**
 * @describtion: 334. 递增的三元子序列
 * @author: CaiJm
 * @Date: 2022-01-12 9:23
 */
public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        int min = nums[0];
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > second) return true;
            if (num > min && num <= second) {
                second = num;
            }
            if (num <= min) {
                if (num > third) {
                    min = third;
                    second = num;
                }
                if (num < third) {
                    third = num;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        increasingTriplet(new int[]{1,5,0,4,1,3});
    }
}

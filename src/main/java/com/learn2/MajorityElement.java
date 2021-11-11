package com.learn2;

import java.util.HashMap;

/**
 * @describtion: 面试题 17.10. 主要元素
 * @author: CaiJm
 * @Date: 2021-11-02 9:15
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            int k = map.get(nums[i]) + 1;
            map.put(nums[i], k);
            if (k >= nums.length / 2 + 1) {
                return nums[i];
            }
        }
        return -1;
    }

}

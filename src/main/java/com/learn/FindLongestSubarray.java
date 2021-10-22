package com.learn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @describtion: 面试题 17.05.  字母与数字
 * @author: CaiJm
 * @Date: 2021-10-22 10:00
 */
public class FindLongestSubarray {
    public String[] findLongestSubarray(String[] array) {
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> leftIndexMap = new HashMap<>();
        int preSum = 0;
        leftIndexMap.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            preSum += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            if (!leftIndexMap.containsKey(preSum)) {
                leftIndexMap.put(preSum, i);
            } else {
                int leftIndex = leftIndexMap.get(preSum);
                if (i - leftIndex > end - start) {
                    start = leftIndex;
                    end = i;
                }
            }
        }
        return Arrays.copyOfRange(array, start + 1, end + 1);
    }
}

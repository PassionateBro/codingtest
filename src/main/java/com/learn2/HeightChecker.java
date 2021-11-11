package com.learn2;

import java.util.Arrays;

/**
 * @describtion: 1051. 高度检查器
 * @author: CaiJm
 * @Date: 2021-10-27 11:01
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        int num = 0;
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != clone[i]) num++;
        }
        return num;
    }
}

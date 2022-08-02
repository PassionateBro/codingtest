package com.learnnew6;

import java.util.Arrays;

/**
 * @describtion: 1051. 高度检查器
 * @author: CaiJm
 * @Date: 2022-06-15 14:18
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] ints = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (ints[i] != heights[i]) num++;
        }
        return num;
    }
}

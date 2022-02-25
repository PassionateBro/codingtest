package com.learnnew5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @describtion: 84. 柱状图中最大的矩形
 * @author: CaiJm
 * @Date: 2022-02-16 14:22
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}

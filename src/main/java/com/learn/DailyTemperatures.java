package com.learn;

import java.util.Stack;

/**
 * @describtion: 739. 每日温度  (其实本质是处理单调栈)
 * @author: CaiJm
 * @Date: 2021-09-06 9:20
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            /**
             * 取出下标进行元素值的比较
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            /**
             * 注意 放入的是元素位置
             */
            stack.push(i);
        }
        return res;
    }

}

package com.learn;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @describtion: 1130. 叶值的最小代价生成树
 * @author: CaiJm
 * @Date: 2021-09-03 9:21
 */
public class MctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);//哨兵
        int ans = 0;
        for (int i = 0; i < arr.length; i++){
            while (stack.peek() < arr[i])
                ans += stack.pop()*Math.min(arr[i],stack.peek());
            stack.push(arr[i]);
        }

        while(stack.size() > 2)
            ans += stack.pop()*stack.peek();

        return ans;
    }

    public static void main(String[] args) {
        int len = 16;
        System.out.println(Math.log(len * 1.0) / Math.log(2.0));
        System.out.println();
    }
}

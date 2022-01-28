package com.learnnew4;

import java.util.Stack;

/**
 * @describtion: 剑指 Offer 09. 用两个栈实现队列
 * @author: CaiJm
 * @Date: 2022-01-26 15:33
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) return -1;
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(12);
        stack.push(3);
        System.out.println(stack.pop());
    }
}

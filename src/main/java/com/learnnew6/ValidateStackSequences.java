package com.learnnew6;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-31 13:46
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int push = 0, pop = 0;
        Stack<Integer> stack = new Stack<>();
        while (push < pushed.length) {
            stack.push(pushed[push]);
            push++;
            while (pop < popped.length && !stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        return stack.isEmpty();

    }

}

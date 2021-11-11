package com.learn2;

import java.util.Stack;

/**
 * @describtion: 20. 有效的括号
 * @author: CaiJm
 * @Date: 2021-10-27 10:06
 */
public class IsValid {
    private  String a;

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new IsValid();
    }
}

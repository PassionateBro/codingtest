package com.learnnew5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-04-13 11:23
 */

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        char[] chars = s.toCharArray();
        int max = 0;
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                deque.addLast(String.valueOf(chars[i]));
            } else {
                String tempS = "";
                while (!deque.isEmpty() && !deque.peekLast().equals("(")) {
                    tempS = deque.pollLast() + tempS;
                }
                if (!deque.isEmpty() && deque.peekLast().equals("(")) {
                    tempS = deque.pollLast() + tempS + ")";
                    deque.offerLast(tempS);
                }
                max = Math.max(tempS.length(), max);
            }
        }
        int last = 0;
        while (!deque.isEmpty()) {
            String s1 = deque.pollFirst();
            if (s1.length() > 1) {
                last += s1.length();
                max = Math.max(last, max);
            } else {
                last = 0;
            }
        }
        return max;
    }
}

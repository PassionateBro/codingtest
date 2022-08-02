package com.learnnew5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion: 224. 基本计算器
 * @author: CaiJm
 * @Date: 2022-03-30 16:27
 */
class Solution {
    public int calculate(String expression) {
        char[] chars = expression.replaceAll(" ", "").toCharArray();
        Deque<String> deque = new LinkedList<>();
        int i = 0;
        while (i < chars.length) {
            // 数字转换
            if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                StringBuilder s = new StringBuilder();
                while (i < chars.length && chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                    s.append(chars[i]);
                    i++;
                }
                deque.addLast(s.toString());
            } else {
                deque.addLast(String.valueOf(chars[i]));
                i++;
            }
        }
        Deque<String> tempQueue = new LinkedList<>();
        // 去括号
        while (!deque.isEmpty()) {
            if (deque.peekFirst().equals(")")) {
                Deque<String> list = new LinkedList<>();
                while (!tempQueue.peekLast().equals("(")) {
                    list.addFirst(tempQueue.pollLast());
                }
                tempQueue.pollLast();
                tempQueue.addAll(calculateMulti(list));
                deque.pollFirst();
            } else {
                tempQueue.addLast(deque.pollFirst());
            }
        }
        Deque<String> stringDeque = calculateMulti(tempQueue);
        return Integer.valueOf(calculateInAndDe(stringDeque));
    }

    private Deque<String> calculateMulti(Deque<String> tempQueue) {
        Deque<String> list = new LinkedList<>();
        while (!tempQueue.isEmpty()) {
            String s = tempQueue.pollFirst();
            if (s.equals("*")) {
                Integer a = Integer.valueOf(list.pollLast());
                Integer b = Integer.valueOf(tempQueue.pollFirst());
                list.addLast(String.valueOf(a * b));
            } else if (s.equals("/")) {
                Integer a = Integer.valueOf(list.pollLast());
                Integer b = Integer.valueOf(tempQueue.pollFirst());
                list.addLast(String.valueOf(a / b));
            } else {
                list.addLast(s);
            }
        }
        String stringDeque = calculateInAndDe(list);
        list.clear();
        list.addLast(stringDeque);
        return list;
    }

    private String calculateInAndDe(Deque<String> tempQueue) {
        if (tempQueue.size() == 1) {
            return tempQueue.pollFirst();
        }
        String s1 = tempQueue.peekFirst();
        int res = 0;
        if (s1.equals("-") || s1.equals("+")) {
            res = 0;
        } else {
            res = Integer.valueOf(s1);
            tempQueue.pollFirst();

        }
        while (!tempQueue.isEmpty()) {
            String s = tempQueue.pollFirst();
            if (s.equals("+")) {
                res += Integer.valueOf(tempQueue.pollFirst());
            } else if (s.equals("-")) {
                res -= Integer.valueOf(tempQueue.pollFirst());
            }
        }
        return String.valueOf(res);
    }
}

package com.learnnew5;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @describtion: 剑指 Offer 59 - II. 队列的最大值
 * @author: CaiJm
 * @Date: 2022-02-21 17:01
 */
public class MaxQueue {
    Deque<Integer> deque;
    int maxValue;
    HashMap<Integer, Integer> map;

    public MaxQueue() {
        deque = new LinkedList<>();
        maxValue = -1;
        map = new HashMap<>();
    }

    public int max_value() {
        return maxValue;
    }

    public void push_back(int value) {
        deque.addLast(value);
        if (value > maxValue) {
            maxValue = value;
        }
        map.put(value, map.getOrDefault(value, 0) + 1);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        Integer integer = deque.pollFirst();
        Integer put = map.put(integer, map.get(integer) - 1);
        if (integer == maxValue) {
            if (put == 1) {
                maxValue = -1;
                for (Integer v : deque) {
                    if (v > maxValue) {
                        maxValue = v;
                    }
                }
            }
        }
        return integer;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}

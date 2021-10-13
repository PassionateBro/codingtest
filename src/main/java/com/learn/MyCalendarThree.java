package com.learn;

import java.util.TreeMap;

/**
 * @describtion: 732. 我的日程安排表 III
 * @author: CaiJm
 * @Date: 2021-10-12 16:07
 */
public class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();

    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int maxBook = 0;
        int temp = 0;
        for (Integer i : map.values()) {
            temp += i;
            if (temp > maxBook) maxBook = temp;
        }
        return maxBook;
    }
}

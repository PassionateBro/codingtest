package com.learnnew6;

import java.util.TreeMap;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-07-05 9:27
 */
public class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer small = map.lowerKey(start);
        if (small != null && map.get(small) > start) {
            return false;
        }
        Integer small2 = map.lowerKey(end);
        if (small2 != null && small2 >= start) {
            return false;
        }
        Integer large = map.higherKey(end);
        if (large != null && map.get(large) < end) {
            return false;
        }
        Integer large2 = map.higherKey(start);
        if (large2 != null && large2 < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(47, 50);
        myCalendar.book(33, 41);
        myCalendar.book(39, 45);
        myCalendar.book(33, 42);
        myCalendar.book(25, 32);
        myCalendar.book(26, 35);
        myCalendar.book(19, 25);
        myCalendar.book(3, 8);
        myCalendar.book(8, 13);
        myCalendar.book(18, 27);
    }
}

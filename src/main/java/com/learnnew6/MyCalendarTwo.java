package com.learnnew6;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

/**
 * @describtion: 731. 我的日程安排表 II
 * @author: CaiJm
 * @Date: 2022-07-19 13:48
 */
public class MyCalendarTwo {

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
     return true;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> objects = new ArrayList<>();
        for (long i  = 0; i < 400000000; i++) {
            final String apple = "aabbcc" + i ;
            objects.add(apple);
        }
    }
}

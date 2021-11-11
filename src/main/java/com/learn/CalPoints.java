package com.learn;

import java.util.ArrayList;

/**
 * @describtion: 682. 棒球比赛
 * @author: CaiJm
 * @Date: 2021-10-26 17:12
 */
public class CalPoints {
    public int calPoints(String[] ops) {
        ArrayList<Integer> objects = new ArrayList<>();
        int idx = 0;
        for (String s : ops) {
            if (s.equals("+")) {
                objects.add(objects.get(idx - 1) + objects.get(idx - 2));
                idx++;
            } else if (s.equals("D")) {
                objects.add(objects.get(idx - 1) * 2);
                idx++;
            } else if (s.equals("C")) {
                objects.remove(idx - 1);
                idx--;
            } else {
                objects.add(Integer.valueOf(s));
                idx++;
            }
        }
        return objects.stream().mapToInt(c -> c.intValue()).sum();
    }
}

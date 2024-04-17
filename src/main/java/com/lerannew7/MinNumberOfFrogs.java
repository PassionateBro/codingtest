package com.lerannew7;

import java.util.HashMap;
import java.util.Map;

/**
 * @describtion: 1419. 数青蛙
 * @author: CaiJm
 * @Date: 2023-05-06 9:33
 */
public class MinNumberOfFrogs {
    public static int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() < 5) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        char[] chars = croakOfFrogs.toCharArray();
        int res = 1, free = 1;
        for (char c : chars) {
            switch (c) {
                case 'c':
                    if (free == 0) {
                        res++;
                    }
                    map.put(1, map.getOrDefault(1, 0) + 1);
                    if (free > 0) {
                        free--;
                    }
                    break;
                case 'r':
                    Integer integer = map.get(1);
                    if (integer == null || integer < 1) {
                        return -1;
                    }
                    map.put(1, integer - 1);
                    map.put(2, map.getOrDefault(2, 0) + 1);
                    break;
                case 'o':
                    Integer r = map.get(2);
                    if (r == null || r < 1) {
                        return -1;
                    }
                    map.put(2, r - 1);
                    map.put(3, map.getOrDefault(3, 0) + 1);
                    break;
                case 'a':
                    Integer o = map.get(3);
                    if (o == null || o < 1) {
                        return -1;
                    }
                    map.put(3, o - 1);
                    map.put(4, map.getOrDefault(4, 0) + 1);
                    break;
                case 'k':
                    Integer a = map.get(4);
                    if (a == null || a < 1) {
                        return -1;
                    }
                    map.put(4, a - 1);
                    free++;
                    break;
                default:
                    break;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        minNumberOfFrogs("crocracokrakoak");
    }
}

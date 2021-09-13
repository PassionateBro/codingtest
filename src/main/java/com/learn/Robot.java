package com.learn;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-08-24 9:28
 */
public class Robot {
    public static boolean solution(String command, int[][] obstacles, int x, int y) {
        int x1 = 0, y1 = 0, p = 0;
        int len = command.length();
        HashMap<Integer, List> objectObjectHashMap = new HashMap<>();
        for (int i = 0, j = obstacles.length; i < j; i++) {
            int[] obstacle = obstacles[i];
            if (objectObjectHashMap.containsKey(obstacle[0])) {
                objectObjectHashMap.get(obstacle[0]).add(obstacle[1]);
            } else {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(obstacle[1]);
                objectObjectHashMap.put(obstacle[0], objects);
            }
        }
        while (true) {
            if (command.charAt(p) == 'U') {
                y1 += 1;
            } else {
                x1 += 1;
            }
            if (objectObjectHashMap.containsKey(x1)) {
                if (objectObjectHashMap.get(x1).contains(y1)) {
                    return false;
                }
            }
            if (x1 > x || y1 > y) return false;
            if (x1 == x && y1 == y) return true;
            p = p + 1 == len ? 0 : p + 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("RRU", new int[][]{{5, 5}, {9, 4}, {9, 7}, {6, 4}, {7, 0}, {9, 5}, {10, 7}, {1, 1}, {7, 5}}, 1486, 743));
    }
}

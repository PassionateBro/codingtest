package com.learn2;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @describtion: 391. 完美矩形
 * @author: CaiJm
 * @Date: 2021-11-16 9:03
 */
public class IsRectangleCover {
    public static boolean isRectangleCover(int[][] rectangles) {
        TreeSet<Integer> x = new TreeSet<>();
        TreeSet<Integer> y = new TreeSet<>();
        HashSet<String> set = new HashSet<>();
        int total = 0;
        for (int[] point : rectangles) {
            x.add(point[0]);
            x.add(point[2]);
            y.add(point[1]);
            y.add(point[3]);
            String a = point[0] + "," + point[1];
            String b = point[2] + "," + point[3];
            String c = point[0] + "," + point[3];
            String d = point[2] + "," + point[1];
            total = total + ((point[2] - point[0]) * (point[3] - point[1]));
            if (set.contains(a)) {
                set.remove(a);
            } else {
                set.add(a);
            }
            if (set.contains(b)) {
                set.remove(b);
            } else {
                set.add(b);
            }
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
            if (set.contains(d)) {
                set.remove(d);
            } else {
                set.add(d);
            }
        }
        if (set.size() != 4) return false;
        Integer minX = x.first();
        Integer miny = y.first();
        Integer maxX = x.last();
        Integer maxY = y.last();
        if (!set.contains(minX + "," + miny)) return false;
        if (!set.contains(minX + "," + maxY)) return false;
        if (!set.contains(maxX + "," + miny)) return false;
        if (!set.contains(maxX + "," + maxY)) return false;
        if (!(total == (maxX - minX) * (maxY - miny))) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] ints = {{0, 0, 3, 3}, {1, 1, 2, 2}, {1, 1, 2, 2}};
        System.out.println(isRectangleCover(ints));

    }
}

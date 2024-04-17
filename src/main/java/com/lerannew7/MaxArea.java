package com.lerannew7;

import java.util.HashSet;

/**
 * @describtion: 1465. 切割后面积最大的蛋糕
 * @author: CaiJm
 * @Date: 2023-10-27 9:57
 */
public class MaxArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        HashSet<Integer> hSet = new HashSet<>();
        HashSet<Integer> wSet = new HashSet<>();
        for (int i = 0; i < horizontalCuts.length; i++) {
            hSet.add(horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length; i++) {
            wSet.add(verticalCuts[i]);
        }
        int i = 0, j = 0;
//        while (i < h) {
//
//        }
        return 1;
    }
}

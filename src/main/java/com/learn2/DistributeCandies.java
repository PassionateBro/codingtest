package com.learn2;

import java.util.HashSet;

/**
 * @describtion: 575. 分糖果
 * @author: CaiJm
 * @Date: 2021-11-01 9:17
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < len; i++) {
            integers.add(candyType[i]);
        }
        int size = integers.size();
        if (size >= len / 2) {
            return len / 2;
        } else {
            return size;
        }
    }
}

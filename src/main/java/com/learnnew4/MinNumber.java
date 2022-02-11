package com.learnnew4;

import java.util.PriorityQueue;

/**
 * @describtion: 剑指 Offer 45. 把数组排成最小的数
 * @author: CaiJm
 * @Date: 2022-02-10 16:40
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> sort(o1, o2));
        for (int n : nums) {
            queue.add(n);
        }
        String res = "";
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }

    private int sort(int o1, int o2) {
        String a = o1 + "" + o2;
        String b = o2 + "" + o1;
        return a.compareTo(b);
    }
}

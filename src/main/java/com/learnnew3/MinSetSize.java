package com.learnnew3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @describtion: 1338. 数组大小减半
 * @author: CaiJm
 * @Date: 2021-12-29 15:06
 */
public class MinSetSize {
    public static int minSetSize(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Arrays.sort(arr);
        int len = arr.length;
        int temp = -1, sum = 0;
        for (int i : arr) {
            if (i == temp) {
                sum++;
            } else {
                if (sum * 2 >= len) return 1;
                queue.offer(sum);
                temp = i;
                sum = 1;
            }
        }
        queue.offer(sum);
        int res = 0, te = 0;
        while (!queue.isEmpty()) {
            te += queue.poll();
            res++;
            if (te * 2 >= len) break;
        }
        return res;
    }

    public static void main(String[] args) {
        minSetSize(new int[]{1000,1000,3,7});
    }
}

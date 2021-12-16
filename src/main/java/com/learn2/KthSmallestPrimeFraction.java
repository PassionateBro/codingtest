package com.learn2;

import java.util.PriorityQueue;

/**
 * @describtion: 786. 第 K 个最小的素数分数
 * @author: CaiJm
 * @Date: 2021-11-29 11:17
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] * b[1] - b[0] * a[1]);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.add(new int[]{arr[i], arr[j]});
            }
        }
        while (--k > 0) pq.poll();
        return pq.poll();
    }
}

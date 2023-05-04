package com.lerannew7;

import java.util.PriorityQueue;

/**
 * @describtion: 4. 寻找两个正序数组的中位数
 * @author: CaiJm
 * @Date: 2023-03-06 10:49
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int num = nums1.length + nums2.length;
        int a = 0, b = 0;
        while (a < nums1.length || b < nums2.length) {
            int tempA = Integer.MAX_VALUE;
            int tempB = Integer.MAX_VALUE;
            if (a < nums1.length) {
                tempA = nums1[a];
            }
            if (b < nums2.length) {
                tempB = nums2[b];
            }
            if (tempA < tempB) {
                if (left.size() < num / 2) {
                    left.offer(tempA);
                } else {
                    right.offer(tempA);
                }
                a++;
            } else {
                if (left.size() < num / 2) {
                    left.offer(tempB);
                } else {
                    right.offer(tempB);
                }
                b++;
            }
        }
        if (left.size() == right.size()) {
            return (left.poll() + right.poll()) * 1.0 / 2.0;
        } else {
            return right.poll() * 1.0;
        }
    }

}

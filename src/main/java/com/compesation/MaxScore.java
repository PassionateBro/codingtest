package com.compesation;

import java.util.PriorityQueue;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-13 10:20
 */
public class MaxScore {
    public static int maxScore(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                queue.offer(nums[i]);
            }
            max = Math.max(nums[i], max);
        }
        if (max <= 0) return 0;
        if (queue.isEmpty()) return nums.length;
        int res = nums.length - queue.size();
        while (!queue.isEmpty()) {
            sum += queue.poll();
            if (sum > 0) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.add(-1);
        queue.add(-8);
        queue.add(0);
        System.out.println(queue.poll());
        maxScore(new int[]{2, -1, 0, 1, -3, 3, -3});
    }
}

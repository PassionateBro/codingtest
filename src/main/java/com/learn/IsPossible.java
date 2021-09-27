package com.learn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @describtion: 1354. 多次求和构造目标数组
 * <p>
 * 给你一个整数数组target 。一开始，你有一个数组A ，它的所有元素均为 1 ，你可以执行以下操作：
 * <p>
 * 令x为你数组里所有元素的和
 * 选择满足0 <= i < target.size的任意下标i，并让A数组里下标为i处的值为x。
 * 你可以重复该过程任意次
 * 如果能从A开始构造出目标数组target，请你返回 True ，否则返回 False 。
 * @author: CaiJm
 * @Date: 2021-09-15 10:24
 */
public class IsPossible {
    public static boolean isPossible(int[] target) {
        if (target.length == 1 && target[0] != 1) return false;
        PriorityQueue<Long> longs = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        long sum = 0;
        for (int i : target) {
            sum += i;
            longs.offer(Long.valueOf(i));
        }
        long max = 0;
        while (!longs.isEmpty() && longs.peek() != 1L) {
            max = longs.poll();
            sum = sum - max;
            max = max - sum;
            if (max >= sum) max %= sum;   // 继续尝试最大值变成的新的值
            if (sum == 1 && max == 0) return true;
            sum += max;    // 新的数组和
            if (max < 1) {
                return false;
            }
            longs.offer(max);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{8, 5}));
    }
}

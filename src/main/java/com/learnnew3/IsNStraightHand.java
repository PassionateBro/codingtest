package com.learnnew3;

import java.util.*;

/**
 * @describtion: 846. 一手顺子
 * @author: CaiJm
 * @Date: 2021-12-30 9:32
 */
public class IsNStraightHand {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        // 排除无法分组的情况
        if (hand == null || hand.length % groupSize != 0) {
            return false;
        }
        // groupSize为1时肯定符合条件
        if (groupSize == 1) {
            return true;
        }
        // 预先排序，便于按序入队元素
        Arrays.sort(hand);
        int n = hand.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 生成一个新组
            if (queue.isEmpty() || queue.peek()[0] == hand[i]) {
                queue.offer(new int[]{hand[i], 1});
                // 当前组可以变长
            } else if (queue.peek()[0] + 1 == hand[i]) {
                int[] cur = queue.poll();
                // 更新当前组连续牌的结尾元素
                cur[0] = hand[i];
                // 更新当前组连续牌的个数，并判断是否已到达结尾
                if (++cur[1] != groupSize) {
                    queue.offer(cur);
                }
                // 当前组无法继续连续下去
            } else {
                return false;
            }
        }

        return queue.isEmpty();
    }

    public static void main(String[] args) {
        isNStraightHand(new int[]{34, 80, 89, 15, 38, 69, 19, 17, 97, 98, 26, 77, 8, 31, 79, 70, 103, 3, 13, 21, 81, 53, 33, 14, 60, 68, 33, 59, 84, 23, 97, 90, 76, 82, 66, 83, 23, 22, 16, 18, 98, 25, 16, 61, 84, 100, 4, 68, 101, 25, 23, 9, 10, 55, 2, 67, 39, 52, 102, 99, 40, 11, 83, 24, 81, 53, 96, 23, 13, 24, 99, 67, 22, 51, 31, 58, 78, 88, 5, 15, 24, 32, 81, 91, 96, 16, 54, 22, 56, 69, 14, 82, 32, 34, 83, 24, 37, 82, 54, 21},
                4);
    }
}

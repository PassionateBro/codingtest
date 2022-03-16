package com.learnnew5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion: 1944. 队列中可以看到的人数
 * @author: CaiJm
 * @Date: 2022-03-10 14:18
 */
public class CanSeePersonsCount {
    public static int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(heights[heights.length - 1]);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] >= deque.peekLast()) {
                int idx = 0;
                while (!deque.isEmpty() && deque.peekLast() <= heights[i]) {
                    deque.pollLast();
                    idx++;
                }
                res[i] = deque.isEmpty() ? idx : idx + 1;
            } else {
                res[i] = 1;
            }
            deque.addLast(heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        canSeePersonsCount(new int[]{3, 1, 5, 8, 6});
    }
}

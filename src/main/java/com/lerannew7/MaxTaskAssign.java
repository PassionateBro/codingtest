package com.lerannew7;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-10-23 10:30
 */
public class MaxTaskAssign {
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0, r = Math.min(tasks.length, workers.length);
        while (l < r) {
            int mid = (l + r) >> 1;
            if (canFinish(mid, tasks, workers, pills, strength)) {
                l = mid;
            } else {
                r = mid - 1;
            }
            if (l == r - 1) {
                if (canFinish(r, tasks, workers, pills, strength)) {
                    l = r;
                }
                break;
            }
        }
        return l;
    }

    static boolean canFinish(int num, int tasks[], int workers[], int pills, int strength) {
        Deque<Integer> deque = new ArrayDeque<>();
        int p = workers.length - 1;
        for (int i = num - 1; i >= 0; i--) {
            while (p >= workers.length - num && workers[p] >= tasks[i] - strength) {
                deque.add(workers[p]);
                p--;
            }
            if (deque.size() > 0 && deque.getFirst() >= tasks[i]) {
                deque.removeFirst();
            } else {
                if (pills == 0 || deque.size() == 0) {
                    return false;
                }
                deque.removeLast();
                pills--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("1313579440F2036".substring(11, 13)));
    }
}

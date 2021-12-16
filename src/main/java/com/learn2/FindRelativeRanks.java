package com.learn2;


import java.util.PriorityQueue;

/**
 * @describtion: 506. 相对名次
 * @author: CaiJm
 * @Date: 2021-12-02 9:21
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        PriorityQueue<int[]> objects = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < score.length; i++) {
            objects.offer(new int[]{i, score[i]});
        }

        for (int i = 0; i < score.length; i++) {
            switch (i) {
                case 0:
                    res[objects.poll()[0]] = "Gold Medal";
                    break;
                case 1:
                    res[objects.poll()[0]] = "Silver Medal";
                    break;
                case 2:
                    res[objects.poll()[0]] = "Bronze Medal";
                    break;
                default:
                    res[objects.poll()[0]] = String.valueOf(i + 1);
                    break;
            }

        }
        return res;
    }
}

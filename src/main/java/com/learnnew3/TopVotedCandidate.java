package com.learnnew3;

import java.util.Map;
import java.util.TreeMap;

/**
 * @describtion: 911. 在线选举
 * @author: CaiJm
 * @Date: 2021-12-23 10:50
 */
public class TopVotedCandidate {
    TreeMap<Integer, Integer> rankMap = new TreeMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int len = persons.length;
        int[] ticketsArr = new int[len];
        int i = 0;
        int tMax = 0;
        int p = -1;
        while (i < len) {
            ticketsArr[persons[i]]++;
            if (ticketsArr[persons[i]] >= tMax) {
                tMax = ticketsArr[persons[i]];
                p = persons[i];
            }
            rankMap.put(times[i], p);
            i++;
        }
    }

    public int q(int t) {
        Map.Entry<Integer, Integer> entry = rankMap.floorEntry(t);
        if (entry != null) return entry.getValue();
        return 0;
    }
}

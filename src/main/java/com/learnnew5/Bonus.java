package com.learnnew5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @describtion: LCP 05. 发 LeetCoin (超时了 没通过)
 * @author: CaiJm
 * @Date: 2022-02-18 13:39
 */
public class Bonus {
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Long>> map = new HashMap<>(n);
        HashMap<Integer, Integer> parentMap = new HashMap<>(n);
        for (int i = 0; i < leadership.length; i++) {
            int leader = leadership[i][0];
            int branch = leadership[i][1];
            if (!map.containsKey(leader)) {
                ArrayList<Long> value = new ArrayList<>();
                value.add(0L);
                map.put(leader, value);
            }
            if (!map.containsKey(branch)) {
                ArrayList<Long> value = new ArrayList<>();
                value.add(0L);
                map.put(branch, value);
            }
            map.get(leader).add((long) branch);
            parentMap.put(branch, leader);
        }

        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 1 || operations[i][0] == 2) {
                long addValue = addCoin(operations[i][0], operations[i][1], operations[i][2], map);
                parentAdd(operations[i][1], parentMap, map, addValue);
            } else {
                res.add(queryCoin(operations[i][1], map));
            }
        }
        int[] ints = new int[res.size()];
        for (int i = 0, size = res.size(); i < size; i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    private void parentAdd(int branch, HashMap<Integer, Integer> parentMap, HashMap<Integer, ArrayList<Long>> map, long value) {
        if (parentMap.containsKey(branch)) {
            int parent = parentMap.get(branch);
            ArrayList<Long> longs = map.get(parent);
            longs.set(0, longs.get(0) + value);
            parentAdd(parent, parentMap, map, value);
        }
    }

    private int queryCoin(int leader, HashMap<Integer, ArrayList<Long>> map) {
        long res = map.get(leader).get(0);
        return (int) (res % 1000000007);
    }

    private long addCoin(int operation, int member, int coin, HashMap<Integer, ArrayList<Long>> map) {
        if (operation == 1) {
            ArrayList<Long> longs = map.get(member);
            longs.set(0, longs.get(0) + coin);
            return coin;
        }
        if (operation == 2) {
            ArrayList<Long> longs = map.get(member);
            int size = longs.size();
            long value = coin;
            for (int i = 1; i < size; i++) {
                value += addCoin(2, longs.get(i).intValue(), coin, map);
            }
            longs.set(0, longs.get(0) + value);
            return value;
        }
        return 0;
    }
}

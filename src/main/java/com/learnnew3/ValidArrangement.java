package com.learnnew3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * @describtion: 2097. 合法重新排列数对
 * @author: CaiJm
 * @Date: 2021-12-31 15:20
 */

public class ValidArrangement {
    public static int[][] validArrangement(int[][] pairs) {
        // key = last, value =  chain
        HashMap<Integer, LinkedList<LinkedList<int[]>>> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (map.containsKey(pair[0])) {
                LinkedList<LinkedList<int[]>> linkedLists = map.get(pair[0]);
                LinkedList<int[]> chain = linkedLists.getFirst();
                linkedLists.remove(0);
                if (linkedLists.size() == 0) {
                    map.remove(pair[0]);
                }
                chain.add(pair);
                if (map.containsKey(pair[1])) {
                    map.get(pair[1]).add(chain);
                } else {
                    LinkedList<LinkedList<int[]>> list = new LinkedList<>();
                    list.add(chain);
                    map.put(pair[1], list);
                }
            } else {
                LinkedList<LinkedList<int[]>> firstList = new LinkedList<>();
                LinkedList<int[]> firstChain = new LinkedList<>();
                firstChain.add(pair);
                firstList.add(firstChain);
                map.put(pair[1], firstList);
            }
        }
        Set<Integer> integers = map.keySet();
        int resKey = 0;
        for (Integer integer : integers) {
            if (resKey == 0) resKey = integer;
            LinkedList<int[]> list = map.get(integer).get(0);
            int first = list.get(0)[0];
            if (map.containsKey(first)) {
                LinkedList<int[]> linkedList = map.get(first).get(0);
                if (!linkedList.equals(list)) map.get(first).get(0).addAll(list);
            } else {
                resKey = integer;
            }
        }
        LinkedList<int[]> linkedList = map.get(resKey).get(0);
        int[][] ints = new int[pairs.length][2];
        for (int i = 0; i < pairs.length; i++) {
            ints[i] = linkedList.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[][] ints = {{8,5},{8,7},{0,8},{0,5},{7,0},{5,0},{0,7},{8,0},{7,8}};
        validArrangement(ints);
    }
}

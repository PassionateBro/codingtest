package com.learnnew6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-24 13:54
 */
public class ReachableNodes {
    private int res = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new ArrayList<>());
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> reachNode = new HashSet<>();
        List<Integer> integers = map.get(0);
        dfs(reachNode, set, integers, map);
        return res + 1;
    }

    private void dfs(HashSet<Integer> reachNode, HashSet<Integer> set, List<Integer> integers, HashMap<Integer, List<Integer>> map) {
        for (Integer i : integers) {
            if (i == 0) continue;
            if (set.contains(i)) {
                continue;
            }
            if (!reachNode.add(i)) {
                continue;
            }
            res++;
            dfs(reachNode, set, map.get(i), map);
        }
    }

    public static void main(String[] args) {
        ReachableNodes s = new ReachableNodes();
        s.reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5});
    }
}

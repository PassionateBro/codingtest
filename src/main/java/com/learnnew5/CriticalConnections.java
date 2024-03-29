package com.learnnew5;

import java.util.*;

/**
 * @describtion: 1192. 查找集群内的「关键连接」
 * @author: CaiJm
 * @Date: 2022-03-17 17:12
 */
public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 构建一个map，存放每个节点的相邻节点有哪些
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(connections, map);

        // 创建一个数组，存放每个节点的id是什么
        int[] id = new int[n];
        Arrays.fill(id, -1);

        // 选取一个点作为根节点，dfs向下递归，过程中识别出哪个边是critical connection
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 0, -1, id, map, res);    // 假设根节点有一个编号是-1父节点

        return res;
    }

    public int dfs(int node, int nodeID, int par, int[] id, Map<Integer, Set<Integer>> map, List<List<Integer>> res) {
        id[node] = nodeID;

        Set<Integer> set = map.get(node);
        for (Integer neighbor : set) {
            if (neighbor == par) {
                continue;
            } else if (id[neighbor] == -1) {
                id[node] = Math.min(id[node], dfs(neighbor, nodeID + 1, node, id, map, res));
            } else {
                id[node] = Math.min(id[node], id[neighbor]);
            }
        }

        if (id[node] == nodeID && node != 0) {
            res.add(Arrays.asList(par, node));
        }

        return id[node];
    }

    public void buildMap(List<List<Integer>> con, Map<Integer, Set<Integer>> map) {
        for (List<Integer> edge : con) {
            int n1 = edge.get(0);
            int n2 = edge.get(1);

            Set<Integer> n1n = map.getOrDefault(n1, new HashSet<>());
            Set<Integer> n2n = map.getOrDefault(n2, new HashSet<>());

            n1n.add(n2);
            n2n.add(n1);

            map.put(n1, n1n);
            map.put(n2, n2n);
        }
    }
}

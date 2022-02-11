package com.learnnew4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 797. 所有可能的路径
 * @author: CaiJm
 * @Date: 2022-02-10 14:21
 */
public class AllPathsSourceTarget {
    List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        if (graph.length == 0 || graph[0].length == 0) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(graph, 0, list);
        return res;
    }

    private void dfs(int[][] graph, int x, LinkedList<Integer> list) {
        if (x == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (graph[x].length == 0) {
            return;
        }
        for (int i = 0; i < graph[x].length; i++) {
            list.addLast(graph[x][i]);
            dfs(graph, graph[x][i], list);
            list.pollLast();
        }
    }
}

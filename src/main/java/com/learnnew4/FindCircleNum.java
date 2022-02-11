package com.learnnew4;

/**
 * @describtion: 547. 省份数量
 * @author: CaiJm
 * @Date: 2022-02-08 13:54
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int[] visited = new int[isConnected[0].length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 1) continue;
            find(isConnected, visited, i);
            res++;
        }
        return res;
    }

    public void find(int[][] isConnected, int[] visited, int x) {
        if (visited[x] == 1) return;
        visited[x] = 1;
        for (int i = 0; i < isConnected[x].length; i++) {
            if (isConnected[x][i] == 1 && visited[i] == 0) {
                find(isConnected, visited, i);
            }
        }
    }
}

package com.learnnew5;


/**
 * @describtion: 1319. 连通网络的操作次数
 * @author: CaiJm
 * @Date: 2022-03-17 9:40
 */
public class MakeConnected {
    int parent[];
    int size[];
    int extraCount;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        extraCount = 0;
        for (int connection[] : connections) {
            union(connection[0], connection[1]);
        }
        int neededCount = 0;
        for (int i = 0; i < n; i++) {
            //获得连通分量的数量
            if (parent[i] == i) {
                neededCount++;
            }
        }
        //连通分量的数量减一为需要的额外边数量
        //如果多余边小于额外边，那么返回-1连不起来
        //如果多余边大于等于额外边，那么返回实际需要的额外边数量
        return extraCount >= neededCount - 1 ? neededCount - 1 : -1;
    }

    public void union(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);
        //说明当前两点已联通，因此该边为多余边
        if (root1 == root2) {
            extraCount++;
            return;
        }
        if (size[root1] > size[root2]) {
            parent[root2] = root1;
            size[root1] += size[root2];
        } else {
            parent[root1] = root2;
            size[root2] += size[root1];
        }
    }

    public int find(int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

}
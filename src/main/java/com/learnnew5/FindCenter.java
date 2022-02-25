package com.learnnew5;

/**
 * @describtion: 1791. 找出星型图的中心节点
 * @author: CaiJm
 * @Date: 2022-02-18 9:36
 */
public class FindCenter {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0]) {
            return edges[0][0];
        }
        if (edges[0][0] == edges[1][1]) {
            return edges[1][1];
        }
        if (edges[0][1] == edges[1][0]) {
            return edges[0][1];
        }
        if (edges[0][1] == edges[1][1]) {
            return edges[0][1];
        }
        return -1;
    }
}

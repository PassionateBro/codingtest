package com.learnnew6;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-06-23 10:01
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        int[] ints = new int[isConnected.length];
        int[] roots = new int[isConnected.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
            roots[i] = 1;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 0) {
                    continue;
                }
                int findX = find(i, ints), findY = find(j, ints);
                if (findX != findY) {
                    num++;
                    if (roots[findX] <= roots[findY]) {
                        ints[findX] = findY;
                    } else {
                        ints[findY] = findX;
                    }
                    if (roots[findX] == roots[findY]) {
                        roots[findX]++;
                    }
                }
            }
        }
        return isConnected.length - num;
    }

    private int find(int num, int[] ints) {
        if (ints[num] == num) return num;
        return find(ints[num], ints);
    }

    public static void main(String[] args) {
        FindCircleNum f = new FindCircleNum();
        f.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}

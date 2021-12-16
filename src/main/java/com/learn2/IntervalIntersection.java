package com.learn2;

import java.util.ArrayList;

/**
 * @describtion: 986. 区间列表的交集
 * @author: CaiJm
 * @Date: 2021-12-16 14:46
 */
public class IntervalIntersection {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int aMove = 0;
        int bMove = 0;
        int aLen = firstList.length;
        int bLen = secondList.length;
        while (aMove < aLen && bMove < bLen) {
            int a = firstList[aMove][0], b = firstList[aMove][1];
            int c = secondList[bMove][0], d = secondList[bMove][1];
            if (b <= d) {
                if (b < c) {
                    aMove++;
                    continue;
                }
                list.add(new int[]{Math.max(a, c), b});
                aMove++;
                continue;
            } else {
                if (a <= c) {
                    list.add(new int[]{c, d});
                    bMove++;
                    continue;
                }
            }

            if (a >= c) {
                if (a > d) {
                    bMove++;
                    continue;
                }
                list.add(new int[]{a, Math.min(b, d)});
                bMove++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        intervalIntersection(new int[][]{{3, 5}, {9, 20}},
                new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}});
    }
}

package com.learnnew3;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-04 16:04
 */

public class CanEat {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = candiesCount[i] + sum[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int j = query[0];
            if (j == 0) {
                res[i] = sum[j] > query[1];
                continue;
            }
            boolean a = (long) query[2] * (long) (query[1] + 1) > sum[j - 1];
            boolean b = sum[j] > query[1];
            res[i] = a && b;
        }
        return res;
    }
}

package com.learnnew6;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-19 10:51
 */
public class EdgeScore {
    public static int edgeScore(int[] edges) {
        long[] score = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            score[edges[i]] += i;
        }
        long max = score[0];
        int idx = 0;
        for (int i = 1; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
                idx = i;
            }
        }
        return idx;
    }

}

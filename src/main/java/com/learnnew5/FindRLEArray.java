package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 1868. 两个行程编码数组的积
 * @author: CaiJm
 * @Date: 2022-03-14 13:41
 */
public class FindRLEArray {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        int lastNum = -1;
        int lastCount = -1;
        while (idx1 < encoded1.length && idx2 < encoded2.length) {
            int r = encoded1[idx1][0] * encoded2[idx2][0];
            int min = Math.min(encoded1[idx1][1], encoded2[idx2][1]);
            if (r == lastNum) {
                lastCount += min;
            } else {
                if (lastNum != -1) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(lastNum);
                    list.add(lastCount);
                    res.add(list);
                }
                lastCount = min;
                lastNum = r;
            }
            if (encoded1[idx1][1] > min) {
                encoded1[idx1][1] -= min;
            } else {
                idx1++;
            }
            if (encoded2[idx2][1] > min) {
                encoded2[idx2][1] -= min;
            } else {
                idx2++;
            }
        }
        if (lastNum != -1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(lastNum);
            list.add(lastCount);
            res.add(list);
        }
        return res;
    }
}

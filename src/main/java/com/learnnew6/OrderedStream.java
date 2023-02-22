package com.learnnew6;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-18 14:03
 */
public class OrderedStream {
    int idx;
    int[] ints;
    String[] val;

    public OrderedStream(int n) {
        idx = 1;
        ints = new int[n + 1];
        val = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        ints[idKey] = 1;
        val[idKey] = value;
        ArrayList<String> res = new ArrayList<>();
        while (idx < ints.length && ints[idx] == 1) {
            res.add(val[idx]);
            idx++;
        }
        return res;
    }
}

package com.learnnew5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @describtion: 599. 两个列表的最小索引总和
 * @author: CaiJm
 * @Date: 2022-03-14 11:13
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int idx = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer integer = map.get(list2[i]);
            if (integer != null) {
                int sum = i + integer;
                if (sum < idx) {
                    idx = sum;
                    res.clear();
                    res.add(list2[i]);
                } else if (sum == idx) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

package com.test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-07-13 9:24
 */
public class New {

    public HashMap<String, HashSet<String>> map;

    public void setMap(String value) {
        HashSet<String> objects = new HashSet<>();
        objects.add(value);
        map = new HashMap<>();
        map.put("a", objects);
    }

    public boolean judge(String value) {
        HashSet<String> set = map.get("a");
        if (set != null) {
            return set.contains(value);
        }
        return false;
    }
}

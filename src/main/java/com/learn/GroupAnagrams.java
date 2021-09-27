package com.learn;


import java.util.*;

/**
 * @describtion: 面试题 10.02. 变位词组
 * @author: CaiJm
 * @Date: 2021-09-18 9:15
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> val = new ArrayList<>();
        HashMap<String, List<String>> objectObjectHashMap = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String s1 = String.valueOf(temp);
            if (objectObjectHashMap.containsKey(s1)) {
                objectObjectHashMap.get(s1).add(s);
            } else {
                LinkedList<String> objects = new LinkedList<>();
                objects.add(s);
                objectObjectHashMap.put(s1, objects);
            }
        }
        for (List list : objectObjectHashMap.values()) {
            val.add(list);
        }
        return val;
    }
}

package com.learnnew3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-12 11:04
 */
public class MagicDictionary {
    private HashMap<Integer, HashSet<String>> hashMap;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        hashMap = new HashMap<>(16);
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            HashSet<String> set = hashMap.getOrDefault(len, new HashSet<>());
            set.add(s);
            hashMap.put(len, set);
        }
    }

    public boolean search(String searchWord) {
        char[] search = searchWord.toCharArray();
        HashSet<String> set = hashMap.get(searchWord.length());
        if (set == null) return false;
        for (String s : set) {
            char[] chars = s.toCharArray();
            int diff = 0;
            for (int i = 0; i < search.length; i++) {
                if (chars[i] != search[i]) diff++;
                if (diff > 1) continue;
            }
            if (diff == 1) return true;
        }
        return false;
    }
}

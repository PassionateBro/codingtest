package com.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @describtion: 211. 添加与搜索单词 - 数据结构设计
 * @author: CaiJm
 * @Date: 2021-10-19 16:28
 */
public class WordDictionary {
    Map<Integer, Set<String>> map = new HashMap<>();

    public WordDictionary() {}

    public void addWord(String word) {
        int len = word.length();
        if (map.get(len) != null) {
            map.get(len).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(len, set);
        }
    }

    public boolean search(String word) {
        Set<String> set = map.get(word.length());
        if (set == null) return false;
        if (set.contains(word)) return true;
        char[] ch = word.toCharArray();
        for (String s : set) {
            boolean flag = true;
            char[] str = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (str[i] != ch[i]) {
                    if (ch[i] != '.') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) return true;
        }
        return false;
    }
}

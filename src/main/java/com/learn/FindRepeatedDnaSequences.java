package com.learn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 187 重复的DNA序列
 * @author: CaiJm
 * @Date: 2021-10-08 16:10
 */
public class FindRepeatedDnaSequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String judge = s.substring(i, i + 10);
            if (map.get(judge) == null) {
                map.put(judge, 1);
            } else {
                if (map.get(judge) == 1) {
                    res.add(judge);
                }
                map.put(judge, map.get(judge) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}

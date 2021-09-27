package com.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @describtion: 819. 最常见的单词
 * @author: CaiJm
 * @Date: 2021-09-16 15:52
 */
public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> strings = Arrays.asList(banned);
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String word = "";
        String[] split = paragraph.replaceAll("[^a-zA-Z]", " ").split(" ");
        for (String s : split) {
            if (s.equals(" ") || s.length() <= 0) continue;
            String s1 = s.toLowerCase();
            if (strings.contains(s1)) {
                continue;
            }
            if (map.get(s1) == null) {
                map.put(s1, 1);
            } else {
                map.put(s1, map.get(s1) + 1);
            }
            if (map.get(s1) > max) {
                max = map.get(s1);
                word = s1;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"hit", "bob"}));
    }
}

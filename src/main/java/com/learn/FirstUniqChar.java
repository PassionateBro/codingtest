package com.learn;

import java.util.HashMap;

/**
 * @describtion: 387. 字符串中的第一个唯一字符
 * @author: CaiJm
 * @Date: 2021-10-15 11:19
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(Integer.valueOf(c))) {
                map.put(Integer.valueOf(c), map.get(Integer.valueOf(c)) + 1);
            } else {
                map.put(Integer.valueOf(c), 1);
            }
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.get(Integer.valueOf(s.charAt(i))) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar("loveleetcode");
    }
}

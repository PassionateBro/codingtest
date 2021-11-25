package com.learn2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @describtion: 318. 最大单词长度乘积
 * @author: CaiJm
 * @Date: 2021-11-17 9:44
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        int len = words.length;
        int max = 0;
        ArrayList<HashSet<String>> objects = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            HashSet<String> set = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set.add(String.valueOf(c));
            }
            objects.add(set);
        }
        for (int i = 0; i < len; i++) {
            HashSet<String> set = objects.get(i);
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                HashSet<String> set1 = objects.get(j);
                boolean b = true;
                for (String s : set1) {
                    if (set.contains(s)) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    private static int wordBit(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0;i < n;i++){
            int idx = s.charAt(i)-'a';
            ans |= 1<<idx;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(wordBit("abc"));
    }
}

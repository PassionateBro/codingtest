package com.learn;

import java.util.LinkedList;

/**
 * @describtion: 1078. Bigram 分词
 * @author: CaiJm
 * @Date: 2021-09-28 14:30
 */
public class FindOcurrences {

    public static String[] findOcurrences(String text, String first, String second) {
        LinkedList<String> objects = new LinkedList<>();
        String[] s = text.split(" ");
        int x = 0;
        for (int i = 0; i < s.length; i++) {
            if (x == 0) {
                if (s[i].equals(first)) x = 1;
                continue;
            }
            if (x == 1) {
                if (s[i].equals(second)) {
                    x = 2;
                } else if (s[i].equals(first)) {
                    x = 1;
                } else {
                    x = 0;
                }
                continue;
            }
            if (x == 2) {
                objects.add(s[i]);
                if (s[i].equals(first)) {
                    x = 1;
                    if (s[i].equals(second)) {
                        x = 2;
                    }
                } else {
                    x = 0;
                }
                continue;
            }
        }
        return objects.toArray(new String[objects.size()]);
    }

    public static void main(String[] args) {
        findOcurrences("alice is a good girl she is a good student",
                "a",
                "good");
    }
}

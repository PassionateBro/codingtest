package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-07 9:57
 */
public class DivisibilityArray {
    public static int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur = (cur * 10 + (c - '0')) % m;
            if (cur % m == 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "529282143571";
        divisibilityArray(s,4);
    }
}

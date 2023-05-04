package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-08 9:59
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        if (next[chars.length - 1] == 0) return false;
        return chars.length % (chars.length - next[chars.length - 1]) == 0;
//        for (int i = 0; i < next.length; i++) {
//            System.out.print(chars[i]);
//            System.out.print(" ");
//        }
//        System.out.println(" ");
//        for (int i = 0; i < next.length; i++) {
//            System.out.print(next[i]);
//            System.out.print(" ");
//        }
//        return true;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern sw = new RepeatedSubstringPattern();
        sw.repeatedSubstringPattern("abcabcabc");
    }
}

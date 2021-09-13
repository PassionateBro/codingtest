package com.learn;

import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-09-08 9:19
 */
public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        String[] chart = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-"
                , ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> sets = new HashSet<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            char[] chars = words[i].toCharArray();
            String translate = "";
            for (int j = 0; j < chars.length; j++) {
                translate += chart[chars[j] - 97];
            }
            sets.add(translate);
        }
        return sets.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        uniqueMorseRepresentations.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"});
    }
}

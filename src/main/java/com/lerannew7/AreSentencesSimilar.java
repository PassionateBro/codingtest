package com.lerannew7;

/**
 * @describtion: 1813. 句子相似性 III
 * @author: CaiJm
 * @Date: 2023-01-16 9:54
 */
public class AreSentencesSimilar {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() == 0 || sentence2.length() == 0) {
            return true;
        }
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int left1 = 0, right1 = s1.length - 1, left2 = 0, right2 = s2.length - 1;
        while (left1 < s1.length && left2 < s2.length) {
            if (s1[left1].equals(s2[left2])) {
                left1++;
                left2++;
            } else {
                break;
            }
        }

        while (right1 >= 0 && right2 >= 0) {
            if (s1[right1].equals(s2[right2])) {
                right1--;
                right2--;
            } else {
                break;
            }
        }
        if (left1 == 0 && left2 == 0 && right1 == s1.length - 1 && right2 == s2.length - 1) {
            return false;
        }
        if (right1 - left1 >= 0 && right2 - left2 >= 0) {
            return false;
        }
        return true;
    }
}

package com.learn;

/**
 * @describtion: 824. 山羊拉丁文
 * @author: CaiJm
 * @Date: 2021-09-24 15:54
 */
public class ToGoatLatin {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        int len = s.length;
        String judge = "aeiouAEIOU";
        for (int i = 0; i < len; i++) {
            if (judge.contains(s[i].substring(0, 1))) {
                s[i] = s[i] + "ma";
            } else {
                s[i] = s[i].substring(1) + s[i].substring(0, 1) + "ma";
            }
            for (int j = 1; j <= i + 1; j++) {
                s[i] += "a";
            }
        }
        return String.join(" ", s);
    }
}

package com.learn;

/**
 * @describtion: 1455. 检查单词是否为句中其他单词的前缀
 * @author: CaiJm
 * @Date: 2021-09-27 10:20
 */
public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        char[] search = searchWord.toCharArray();
        for (int i = 0; i < s.length; i++) {
            char[] chars = s[i].toCharArray();
            int num = 0;
            if (chars.length < search.length) continue;
            for (int j = 0; j < search.length; j++) {
                if (chars[j] != search[j]) break;
                num++;
            }
            if (search.length == num) return i + 1;
        }
        return -1;
    }
}

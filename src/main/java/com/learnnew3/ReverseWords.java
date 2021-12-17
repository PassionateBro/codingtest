package com.learnnew3;

import java.util.Stack;

/**
 * @describtion: 151. 翻转字符串里的单词
 * @author: CaiJm
 * @Date: 2021-12-17 14:02
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; ) {
            Stack<Character> objects = new Stack<>();
            while (i >= 0 && chars[i] != ' ') {
                objects.push(chars[i]);
                i--;
            }
            boolean t = false;
            while (!objects.empty()) {
                t = true;
                stringBuilder.append(objects.pop());
            }
            if (t) stringBuilder.append(" ");
            i--;
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}

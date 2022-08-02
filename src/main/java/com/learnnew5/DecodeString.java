package com.learnnew5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion: 394. 字符串解码
 * @author: CaiJm
 * @Date: 2022-03-28 10:05
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder x = new StringBuilder();
        char[] chars = s.toCharArray();
        Deque<String> deque = new LinkedList<>();
        boolean cFirst = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ']') {
                deque.addLast(String.valueOf(chars[i]));
            } else {
                LinkedList<String> characterList = new LinkedList<>();
                LinkedList<String> numberList = new LinkedList<>();
                while (!deque.isEmpty()) {
                    String s1 = deque.peekLast();
                    char c = s1.charAt(0);
                    if (s1.charAt(0) == '[') {
                        deque.pollLast();
                        break;
                    }
                    if (s1.length() > 1) {
                        characterList.addFirst(deque.pollLast());
                        continue;
                    }
                    if (!(c - '0' >= 0 && c - '0' <= 9)) {
                        characterList.addFirst(deque.pollLast());
                    } else {
                        break;
                    }
                }
                while (!deque.isEmpty()) {
                    String s1 = deque.peekLast();
                    char c = s1.charAt(0);
                    if (c - '0' >= 0 && c - '0' <= 9) {
                        numberList.addFirst(deque.pollLast());
                    } else {
                        break;
                    }
                }
                StringBuilder newS = new StringBuilder();
                String charT = charToString(characterList);
                for (int j = 1, times = Integer.valueOf(charToString(numberList)); j <= times; j++) {
                    newS.append(charT);
                }
                deque.addLast(newS.toString());
            }
        }
        while (!deque.isEmpty()) {
            x.append(deque.pollFirst());
        }
        return x.toString();
    }

    private String charToString(LinkedList<String> characterList) {
        StringBuilder s = new StringBuilder();
        while (!characterList.isEmpty()) {
            s.append(characterList.pollFirst());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }
}

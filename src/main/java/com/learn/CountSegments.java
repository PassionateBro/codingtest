package com.learn;

/**
 * @describtion: 434. 字符串中的单词数
 * @author: CaiJm
 * @Date: 2021-10-09 16:57
 */
public class CountSegments {
    public static int countSegments(String s) {
        int count = 0;
        for(int i = 0;i < s.length();i++){
            if((i == 0 || s.charAt(i-1) == ' ') && (s.charAt(i) != ' '))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("    foo    bar"));
    }
}

package com.learn2;


import java.util.HashSet;
import java.util.Set;

/**
 * @describtion: 2085. 统计出现过一次的公共字符串
 * @author: CaiJm
 * @Date: 2021-11-30 13:48
 */
public class CountWords {
    public static int countWords(String[] words1, String[] words2) {
        Set<String> temp = new HashSet<String>();
        Set<String> garbage = new HashSet<String>();  //存储多次出现的元素
        Set<String> count = new HashSet<String>();

        for (String s : words1)  //第一个数组中出现一次的元素
            if (garbage.contains(s))
                continue;
            else if (temp.contains(s)) {
                temp.remove(s);
                garbage.add(s);
            } else
                temp.add(s);

        for (String s : words2)
            if (temp.contains(s)) {  //在第一个字符串中只出现了一次
                if (!count.contains(s) && !garbage.contains(s))
                    count.add(s);
                else {
                    count.remove(s);
                    garbage.add(s);
                }
            } else
                continue;

        return count.size();
    }

}

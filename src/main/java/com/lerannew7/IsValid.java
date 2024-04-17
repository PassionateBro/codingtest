package com.lerannew7;

import org.apache.http.client.utils.DateUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion: 1003. 检查替换后的词是否有效
 * @author: CaiJm
 * @Date: 2023-05-04 9:16
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            deque.addLast(chars[i]);
            while(deque.size() >= 3) {
                Character c = deque.pollLast();
                Character b = deque.pollLast();
                Character a = deque.pollLast();
                StringBuilder temp = new StringBuilder();
                temp.append(a).append(b).append(c);
                if (!temp.toString().equals("abc")) {
                    deque.addLast(a);
                    deque.addLast(b);
                    deque.addLast(c);
                    break;
                }
            }
        }
        return deque.isEmpty();
    }

}

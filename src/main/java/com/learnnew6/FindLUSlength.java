package com.learnnew6;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @describtion: 522. 最长特殊序列 II
 * @author: CaiJm
 * @Date: 2022-06-27 11:17
 */
public class FindLUSlength {
    public int findLUSlength(String[] strs) {
        HashSet<String> garbage = new HashSet<>();
        int max = 1;
        for (String s : strs) {
            max = Math.max(s.length(), max);
        }
        for (int i = max; i >= 1; i--) {
            int special = findSpecial(i, strs, garbage);
            if (special > 0) return special;
        }
        return -1;
    }


    public int findSpecial(int len, String[] strs, HashSet<String> garbage) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (s.length() < len) {
                continue;
            }
            Deque<String> tempQueue = new LinkedList<>();
            tempQueue.addLast("");
            getAllSubStr(strs[i].toCharArray(), len, 0, set, garbage, tempQueue);
        }
        if (set.size() > 0) {
            return len;
        }
        return -1;
    }

    public void getAllSubStr(char[] s, int len, int idx, HashSet<String> set, HashSet<String> garbage, Deque<String> queue) {
        if (idx >= s.length) return;
        int size = queue.size();
        if (size == 0) return;
        for (int i = 0; i < size; i++) {
            String s1 = queue.pollFirst();
            String newS = s1 + s[idx];
            if (newS.length() == len) {
                if (!garbage.contains(newS)) {
                    boolean res = set.add(newS);
                    if (!res) {
                        set.remove(newS);
                        garbage.add(newS);
                    }
                }
            } else {
                queue.addLast(newS);
            }
            queue.addLast(s1);
        }
        getAllSubStr(s, len, idx + 1, set, garbage, queue);
    }

    public static void main(String[] args) {
        FindLUSlength findLUSlength = new FindLUSlength();
        findLUSlength.findLUSlength(new String[]{"aaa", "aaa", "aa"});
    }
}

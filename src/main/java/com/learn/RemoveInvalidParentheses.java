package com.learn;

import java.util.*;

/**
 * @describtion: 301. 删除无效的括号
 * @author: CaiJm
 * @Date: 2021-10-27 9:27
 */
public class RemoveInvalidParentheses {
    int sum;
    int len;
    Set<String> list = new HashSet<String>();
    int ans;

    public List<String> removeInvalidParentheses(String s) {
        Deque<Character> deque = new LinkedList<>();
        sum = s.length();
        len = s.length();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addFirst('(');
            } else if (s.charAt(i) == ')') {
                if (!deque.isEmpty()) {
                    deque.removeFirst();
                } else sum--;
            } else cnt++;
        }
        sum -= deque.size();
        ans = (sum - cnt) / 2;
        String str = "";
        dfs(s, str, 0, 0, 0);
        List<String> lists = new ArrayList<>();
        for (String ss : list) {
            lists.add(ss);
        }
        return lists;
    }

    private void dfs(String s, String str, int i, int cntl, int cntr) {
        if (i == len) {
            if (cntl == ans && cntl == cntr && str.length() == sum) {
                list.add(new String(str));
            }
            return;
        }
        if (s.charAt(i) == '(') {
            dfs(s, str + '(', i + 1, cntl + 1, cntr);
            dfs(s, str, i + 1, cntl, cntr);
        } else if (s.charAt(i) == ')') {
            if (cntr < cntl)
                dfs(s, str + ')', i + 1, cntl, cntr + 1);
            dfs(s, str, i + 1, cntl, cntr);
        } else dfs(s, str + s.charAt(i), i + 1, cntl, cntr);
    }
}

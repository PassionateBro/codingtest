package com.learn;

/**
 * @describtion: 38. 外观数列
 * @author: CaiJm
 * @Date: 2021-10-15 9:25
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder();
            char[] chars = res.toCharArray();
            char temp = chars[0];
            int idx = 0;
            for (char c : chars) {
                if (c == temp) {
                    idx++;
                } else {
                    str.append(idx).append(temp);
                    temp = c;
                    idx = 1;
                }
            }
            str.append(idx).append(temp);
            res = str.toString();
        }
        return res;
    }
}

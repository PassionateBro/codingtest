package com.learnnew3;

/**
 * @describtion: 1576. 替换所有的问号
 * @author: CaiJm
 * @Date: 2022-01-05 9:31
 */
public class ModifyString {
    public String modifyString(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        char temp = '#';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = 'a';
            }
            char before = '@';
            if (i > 0) {
                before = chars[i - 1];
            }
            char after = '#';
            if (i < chars.length - 1) {
                after = chars[i + 1];
            }
            while (chars[i] == before || chars[i] == after) {
                chars[i] = (char) (chars[i] + 1);
                if (chars[i] > 122) {
                    chars[i] = 'a';
                }
            }
            res.append(chars[i]);
        }
        return res.toString();
    }
}

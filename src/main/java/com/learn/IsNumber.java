package com.learn;

/**
 * @describtion: 65. 有效数字
 * @author: CaiJm
 * @Date: 2021-09-28 15:04
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == 'E') return false;
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E') return false;
        String[] split = s.split("[eE]");
        if (split.length > 2 || split.length <= 0) return false;
        String s1 = split[0];
        if (split.length == 1) {
            return judgePre(s1);
        } else {
            boolean resS1 = judgePre(s1);
            String s2 = split[1];
            char[] chars = s2.toCharArray();
            boolean num = true;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (i == 0) {
                    if (c == '+' || c == '-') {
                        num = false;
                        continue;
                    }
                }
                if ((c < '0' || c > '9')) {
                    return false;
                } else {
                    num = true;
                }
            }
            return resS1 && num;
        }
    }

    private boolean judgePre(String s1) {
        char[] chars = s1.toCharArray();
        boolean dot = true;
        boolean num = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                if (c == '+' || c == '-') {
                    num = false;
                    continue;
                }
            }
            if ((c < '0' || c > '9')) {
                if (c == '.' && dot) {
                    boolean left = false, right = false;
                    if (i - 1 >= 0) {
                        if (chars[i - 1] >= '0' || chars[i - 1] <= '9') left = true;
                    }
                    if (i + 1 < chars.length) {
                        if (chars[i + 1] >= '0' || chars[i + 1] <= '9') left = true;
                    }
                    if (left || right) {
                        dot = false;
                        continue;
                    } else {
                        return false;
                    }
                }
                return false;
            } else {
                num = true;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new IsNumber().isNumber("4e+"));
    }
}

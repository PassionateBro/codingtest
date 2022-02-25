package com.learnnew5;

/**
 * @describtion: 剑指 Offer 20. 表示数值的字符串
 * @author: CaiJm
 * @Date: 2022-02-21 15:25
 */
public class IsNumber {
    public boolean isNumber(String s) {
        char[] r = s.trim().toCharArray();
        // 符号
        boolean a = false;
        // e / E
        boolean e = false;
        // 数字
        boolean number = false;
        // .
        boolean point = false;

        boolean res = true;
        for (int i = 0; i < r.length; i++) {
            if (r[i] == ' ') {
                if (a || e || number || point) {
                    return false;
                }
                continue;
            }
            int num = r[i] - '0';
            if (num >= 0 && num <= 9) {
                number = true;
            } else if (r[i] == 'e' || r[i] == 'E') {
                if (e || !number || i == r.length - 1 || (i == r.length - 2 && (r[i + 1] == '+' || r[i + 1] == '-'))) {
                    res = false;
                    break;
                }
                e = true;
                a = false;
            } else if (r[i] == '.') {
                if (point || e || r.length == 1 || (i <= r.length - 2 && (r[i + 1] == ' ' || r[i + 1] == '-' || r[i + 1] == '+'))) {
                    res = false;
                    break;
                }
                point = true;
            } else if (r[i] == '+' || r[i] == '-') {
                if (a || i + 1 >= r.length || r[i + 1] == 'e' || r[i + 1] == 'E' || (i > 0 && r[i - 1] - '0' <= 9 && r[i - 1] - '0' >= 0)) {
                    res = false;
                    break;
                }
                a = true;
            } else {
                return false;
            }
        }
        return res && number;
    }
}

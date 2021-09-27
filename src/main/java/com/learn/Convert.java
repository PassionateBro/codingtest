package com.learn;

/**
 * @describtion: 6. Z 字形变换
 * @author: CaiJm
 * @Date: 2021-09-13 16:12
 */
public class Convert {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        String res = "";
        for (int i = 1; i <= numRows; i++) {
            int index = i - 1;
            StringBuilder sub = new StringBuilder();
            while (index < len) {
                if ((index + 1) % (numRows - 1) == 1 || numRows == 2) {
                    sub.append(s.charAt(index));
                } else {
                    sub.append(s.charAt(index));
                    if (index + 2 * (numRows - i) < len && numRows != i) {
                        sub.append(s.charAt(index + 2 * (numRows - i)));
                    }
                }
                index = index + 2 * (numRows - 1);
            }
            res += sub.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert("ABC", 2));
    }
}

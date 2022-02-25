package com.learnnew5;

/**
 * @describtion: 剑指 Offer 67. 把字符串转换成整数
 * @author: CaiJm
 * @Date: 2022-02-21 16:10
 */
public class StrToInt {
    public static int strToInt(String str) {
        String trim = str.trim();
        Boolean min = false;
        char[] chars = trim.toCharArray();
        int beginIdx = -1, endIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                if (i + 1 < chars.length && chars[i + 1] - '0' >= 0 && chars[i + 1] - '0' <= 9) {
                    if (chars[i] == '-') {
                        min = true;
                    }
                    beginIdx = i + 1;
                } else {
                    return 0;
                }
            } else if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                beginIdx = i;
            } else {
                return 0;
            }
            if (beginIdx > -1) {
                endIdx = beginIdx;
                while (endIdx < chars.length) {
                    if (beginIdx == endIdx && chars[endIdx] == '0') {
                        beginIdx++;
                        endIdx++;
                        continue;
                    }
                    if (chars[endIdx] - '0' >= 0 && chars[endIdx] - '0' <= 9) {
                        endIdx++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        if (endIdx == -1) return 0;
        String substring = trim.substring(beginIdx, endIdx);
        if (substring.equals("+") || substring.equals("-") || substring.trim().length() == 0) return 0;
        Long value = 0L;
        if (substring.length() > 32) {
            value = Long.valueOf(Integer.MAX_VALUE) + 1;
        } else {
            value = Long.valueOf(substring);

        }
        if (min) {
            value = -value;
        }
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return value.intValue();
    }

    public static void main(String[] args) {
        strToInt("-91283472332");
    }

}

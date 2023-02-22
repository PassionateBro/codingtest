package com.learnnew6;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-19 11:07
 */
public class SmallestNumber {
    public String smallestNumber(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] res = new int[chars.length + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                // 上升
                if (chars[j] == 'D') {
                    if (res[j] < res[j + 1]) {
                        int temp = res[j];
                        res[j] = res[j + 1];
                        res[j + 1] = temp;
                    }
                } else {
                    if (res[j] > res[j + 1]) {
                        int temp = res[j];
                        res[j] = res[j + 1];
                        res[j + 1] = temp;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }
}

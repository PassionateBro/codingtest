package com.learn2;


import java.util.Arrays;

/**
 * @describtion: 423. 从英文中重建数字
 * @author: CaiJm
 * @Date: 2021-11-24 9:19
 */
public class OriginalDigits {
    //                                              z      o      w        r       u      f        x      v(n)     h        i
    //                                            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"

    public String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int[] res = new int[10];
        Arrays.fill(res, 0);
        for (char c : chars) {
            if (c == 'z') res[0]++;
            if (c == 'w') res[2]++;
            if (c == 'x') res[6]++;
            if (c == 'u') res[4]++;
            if (c == 'f') res[5]++;
            if (c == 'o') res[1]++;
            if (c == 'r') res[3]++;
            if (c == 'v') res[7]++;
            if (c == 'h') res[8]++;
            if (c == 'i') res[9]++;
        }
        res[1] = res[1] - res[0] - res[4]- res[2];
        res[3] = res[3] - res[0] - res[4];
        res[5] = res[5] - res[4];
        res[7] = res[7] - res[5];
        res[8] = res[8] - res[3];
        res[9] = res[9] - res[6] - res[8] - res[5];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}

package com.learn2;

import cn.hutool.core.date.DateUtil;

/**
 * @describtion: 1869. 哪种连续子字符串更长
 * @author: CaiJm
 * @Date: 2021-11-12 10:05
 */
public class CheckZeroOnes {
    public static boolean checkZeroOnes(String s) {
        int zero = 0;
        int one = 0;
        int tempzero = 0;
        int tempone = 0;
        boolean zo = true;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                tempone++;
                one = Math.max(one, tempone);
                if (!zo) {
                    tempzero = 0;
                    zo = true;
                }
            }
            if (c == '0') {
                tempzero++;
                zero = Math.max(zero, tempzero);
                if (zo) {
                    tempone = 0;
                    zo = false;
                }
            }
        }
        return one > zero;
    }

    public static void main(String[] args) {
        checkZeroOnes("111000");
        System.out.println(DateUtil.thisDayOfWeek());
    }
}

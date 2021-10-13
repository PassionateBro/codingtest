package com.learn;

/**
 * @describtion: 66. 加一
 * @author: CaiJm
 * @Date: 2021-10-12 17:41
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        boolean pa = true;
        while (i >= 0) {
            if (digits[i] != 9) pa = false;
            digits[i] = digits[i] + 1;
            if (digits[i] != 10) break;
            digits[i] = 0;
            i = i - 1;
        }
        if (pa) {
            int[] ints = new int[len + 1];
            ints[0] = 1;
            return ints;
        } else {
            return digits;
        }
    }
}

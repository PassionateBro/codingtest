package com.lerannew7;

import java.util.Arrays;

/**
 * @describtion: 1545. 找出第 N 个二进制字符串中的第 K 位
 * @author: CaiJm
 * @Date: 2023-02-20 13:45
 */
public class FindKthBit {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        if (n == 2) {
            return "011".charAt(k - 1);
        }
        char[] res = new char[]{'0', '1', '1'};
        for (int i = 3; i <= n; i++) {
            int num = res.length / 2;
            char[] temp = Arrays.copyOf(res, res.length);
            temp[num] = temp[num] == '0' ? '1' : '0';
            char[] newChar = Arrays.copyOf(res, res.length * 2 + 1);
            newChar[res.length] = '1';
            for (int j = res.length + 1; j < newChar.length; j++) {
                newChar[j] = temp[j - res.length - 1];
            }
            res = newChar;
        }
        return res[k - 1];
    }
}

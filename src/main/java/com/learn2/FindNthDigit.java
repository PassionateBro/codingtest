package com.learn2;

/**
 * @describtion: 400. 第 N 位数字
 * @author: CaiJm
 * @Date: 2021-11-30 9:08
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int d = 1, c = 9;
        // 注意 d * c 可能超过 int 最大值
        while(n > (long) d * c) {
            n -= d * c;
            d++;
            c *= 10;
        }
        // 找到第 n 位所在数字
        int num = (int)Math.pow(10, d - 1) + (n - 1) / d;
        int dIdx = (n - 1) % d;
        return Integer.toString(num).charAt(dIdx) - '0';

    }
}

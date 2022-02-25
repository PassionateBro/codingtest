package com.learnnew5;

/**
 * @describtion: 剑指 Offer 44. 数字序列中某一位的数字
 * @author: CaiJm
 * @Date: 2022-02-25 14:34
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        //n是从0开始计数去掉前面10个数字所以还要加1
        n -= 9;
        //本轮的开始数字
        int start = 10;
        //该轮数字的个数
        long cnt = 90;
        //本轮数字的位数
        long digit = 2;
        while (n > cnt * digit) {
            n -= cnt * digit;
            cnt *= 10;
            digit++;
            start *= 10;
        }
        //即此时计算的是从start开始下标为n-1的数字
        long num = start + (n - 1) / digit;
        //num从左到右第几位
        int pos = (int) ((n - 1) % digit);
        int res = 0;
        for (int i = pos; i < digit; i++) {
            res = (int) (num % 10);
            num /= 10;
        }
        return res;
    }
}

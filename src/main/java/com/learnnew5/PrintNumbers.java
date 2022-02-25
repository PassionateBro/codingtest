package com.learnnew5;

/**
 * @describtion: 剑指 Offer 17. 打印从1到最大的n位数
 * @author: CaiJm
 * @Date: 2022-02-24 13:39
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}

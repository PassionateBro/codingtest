package com.learnnew5;

/**
 * @describtion: 剑指 Offer 56 - I. 数组中数字出现的次数
 * @author: CaiJm
 * @Date: 2022-02-16 10:41
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        //找到ret二进制数中第几位是1
        int target = 1;//初始位0001
        while ((target & ret) == 0) {//如果target第一个二进制位不为1，就将target左移一位位0010，然后与相与，判断ret第二位是否为一.按此循环，知道找到ret的第一个为1的二进制位
            target = target << 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & target) == 0) {//第一组
                a ^= num;
            } else {//第二组
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}

package com.learnnew5;

/**
 * @describtion: 剑指 Offer 31. 栈的压入、弹出序列
 * @author: CaiJm
 * @Date: 2022-02-21 14:59
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int num : pushed) {
            pushed[i] = num;
            while (i >= 0 && pushed[i] == popped[j]) {
                j++;
                i--;
            }
            i++;
        }
        return i == 0;
    }
}

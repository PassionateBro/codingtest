package com.learn;

/**
 * @describtion: 476. 数字的补数
 * @author: CaiJm
 * @Date: 2021-10-18 9:24
 */
public class FindComplement {
    public int findComplement(int num) {
        int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return num ^ c;

    }


}

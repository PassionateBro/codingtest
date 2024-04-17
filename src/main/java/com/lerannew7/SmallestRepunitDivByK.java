package com.lerannew7;

/**
 * @describtion: 1015. 可被 K 整除的最小整数
 * @author: CaiJm
 * @Date: 2023-05-10 9:14
 */
public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        int p=0;
        for(int i=1;i<=k;i++){
            p=(p*10+1)%k;
            if(p==0){return i;}
        }
        return -1;
    }
}

package com.learn2;

/**
 * @describtion: 458. 可怜的小猪
 * @author: CaiJm
 * @Date: 2021-11-25 9:11
 */
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testTimes = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while(Math.pow(testTimes,pigs) < buckets){
            pigs++;
        }
        return pigs;
    }
}

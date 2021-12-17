package com.learn2;

/**
 * @describtion: 1518. 换酒问题
 * @author: CaiJm
 * @Date: 2021-12-17 9:32
 */
public class NumWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            res = res + (numBottles / numExchange);
            numBottles = numBottles % numExchange + (numBottles / numExchange);
        }
        return res;
    }
}

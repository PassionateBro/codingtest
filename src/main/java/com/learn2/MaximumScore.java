package com.learn2;

import java.util.PriorityQueue;

/**
 * @describtion: 1753. 移除石子的最大得分
 * @author: CaiJm
 * @Date: 2021-12-16 17:10
 */
public class MaximumScore {
    public int maximumScore(int a, int b, int c) {
        if(a + b < c) return a + b;
        else if(a + c < b) return a + c;
        else if(b + c < a) return b + c;

        return (a+b+c)/2;
    }
}

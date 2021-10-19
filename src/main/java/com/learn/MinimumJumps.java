package com.learn;

import java.util.HashSet;

/**
 * @describtion: 1654. 到家的最少跳跃次数 (未完成)
 * @author: CaiJm
 * @Date: 2021-10-14 13:44
 */
public class MinimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : forbidden) {
            hashSet.add(i);
        }
        // TODO
        return 0;
    }
}

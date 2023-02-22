package com.lerannew7;

import java.util.Arrays;

/**
 * @describtion: 1798. 你能构造出连续值的最大数目
 * @author: CaiJm
 * @Date: 2023-02-07 14:10
 */
public class GetMaximumConsecutive {
    public int getMaximumConsecutive(int[] coins) {
        int x = 1;
        Arrays.sort(coins);
        for (int y : coins) if (x >= y) x = x + y;
        return x;
    }
}

package com.lerannew7;

import java.util.HashMap;
import java.util.Map;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-01-17 9:45
 */
public class CountNicePairs {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;

    }
}

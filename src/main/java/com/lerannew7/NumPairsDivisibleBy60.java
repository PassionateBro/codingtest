package com.lerannew7;

import java.util.HashMap;
import java.util.Map;

/**
 * @describtion: 1010. 总持续时间可被 60 整除的歌曲
 * @author: CaiJm
 * @Date: 2023-05-08 9:16
 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        for (int t : time) {
            cnt[t % 60]++;
        }
        long res = 0;
        for (int i = 1; i < 30; i++) {
            res += cnt[i] * cnt[60 - i];
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return (int) res;

    }

}

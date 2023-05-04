package com.lerannew7;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @describtion: 473. 火柴拼正方形
 * @author: CaiJm
 * @Date: 2023-02-27 11:08
 */
public class Makesquare {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int len = totalLen / 4;
        return dfs(0, matchsticks, new int[4], len);
    }

    private boolean dfs(int idx, int[] matchsticks, int[] res, int len) {
        if (idx >= matchsticks.length) {
            return res[0] == res[1] && res[1] == res[2] && res[2] == res[3];
        }
        for (int i = 0; i < 4; i++) {
            if (res[i] + matchsticks[idx] > len) {
                continue;
            }
            while (i < 3) {
                if (res[i] == res[i + 1]) {
                    i++;
                } else {
                    break;
                }
            }
            res[i] += matchsticks[idx];
            if (dfs(idx + 1, matchsticks, res, len)) {
                return true;
            }
            res[i] -= matchsticks[idx];
        }
        return false;
    }

    public static void main(String[] args) {
        Makesquare makesquare = new Makesquare();
        makesquare.makesquare(new int[]{13, 11, 1, 8, 6, 7, 8, 8, 6, 7, 8, 9, 8});
    }

}

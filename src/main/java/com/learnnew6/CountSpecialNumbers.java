package com.learnnew6;

import java.util.Arrays;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-19 11:20
 */
public class CountSpecialNumbers {
    public int countSpecialNumbers(int n) {
        char[] str = Integer.toString(n).toCharArray();
        int[][] f = new int[1 << 10][2];
        f[0][1] = 1;// 边界条件，最左边虚拟一个前导零，已到达上界
        for (char ch : str) {
            int[][] g = new int[1 << 10][2];
            for (int mask = 0; mask < 1 << 10; ++mask) {
                for (int upper = 0; upper <= 1; ++upper) {
                    if (f[mask][upper] == 0) continue;
                    // 计算出位置i的取值范围 [0, max]
                    int max = upper > 0 ? ch - '0' : 9;
                    for (int x = 0; x <= max; ++x) {
                        // 数字不能重复使用
                        if ((mask & 1 << x) != 0) continue;
                        //  mask == 0 && x == 0 表示x是前导零，依旧是任何数字都未被使用
                        int mask2 = mask == 0 && x == 0 ? 0 : mask | 1 << x;
                        // 当i-1到达上界，并且i取值为max，则i也到达上界
                        int upper2 = upper > 0 && x == max ? 1 : 0;
                        g[mask2][upper2] += f[mask][upper];
                    }
                }
            }
            f = g;
        }
        // 最后统计的时候包含了所有位置都为0的情况，所以要减1
        return Arrays.stream(f).flatMapToInt(Arrays::stream).sum() - 1;

    }
}

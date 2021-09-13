package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @describtion: 1622. 奇妙序列
 * <p>
 * 请实现Fancy类 ：
 * <p>
 * Fancy()初始化一个空序列对象。
 * void append(val) 将整数val添加在序列末尾。
 * void addAll(inc)将所有序列中的现有数值都增加inc。
 * void multAll(m)将序列中的所有现有数值都乘以整数m。
 * int getIndex(idx) 得到下标为idx处的数值（下标从 0 开始），并将结果对109 + 7取余。如果下标大于等于序列的长度，请返回-1。
 * @author: CaiJm
 * @Date: 2021-09-13 9:55
 */
public class Fancy {
    private static final int MOD = 1000000007;
    private int[] values = new int[8];
    private long add = 0;                       //加数
    private long mult = 1;                      //乘数
    private long r_mult = 1;                    //乘法逆元
    private int size = 0;                       //append次数
    private static int[] INVERSES = cache();    //乘法逆元缓存表

    public void append(int val) {
        //为了分子防止出现负数还要对 val - add 加上 MOD
        long result = (val - add + MOD) * r_mult % MOD;
        //数组达到最大则扩容
        if (size >= values.length)
            values = Arrays.copyOf(values, size + (size << 1));
        values[size++] = ((int) result);
    }
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    public void multAll(int m) {
        mult = mult * m % MOD;
        add = add * m % MOD;
        //更新乘法逆元:
        //乘法逆元具有可乘性,故 r_mult = r_mult * INVERSES[m] % MOD
        //根据测试, 此题 m <= 100, 故而可以将[0-100]区间内的乘法逆元打表存储, 直接调用
        //若m不限取值, 则r_mult = multiplicativeInverse(m, MOD) % MOD
        r_mult = r_mult * INVERSES[m] % MOD;
    }
    public int getIndex(int idx) {
        if (idx >= size) return -1;
        return (int) ((mult * values[idx] + add) % MOD);
    }
    // 求逆元
    // 1/a % p = a^(p-2) % p
    static int multiplicativeInverse(int x, int mod) {
        long y = 1, m = mod - 2, p = x;
        //类似快速幂运算, 对每步判断取模, 则为快速幂模运算
        for (int i = 0; 1L << i < m; i++, p = p * p % mod)
            if ((m >> i & 1) == 1) y = y * p % mod;
        return (int) y;
    }
    static int[] cache() {
        INVERSES = new int[101];
        INVERSES[0] = 0;
        INVERSES[1] = 1;
        for (int i = 2; i < INVERSES.length; i++)
            INVERSES[i] = multiplicativeInverse(i, MOD);
        return INVERSES;
    }
}

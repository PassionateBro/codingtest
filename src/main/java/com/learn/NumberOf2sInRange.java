package com.learn;

/**
 * @describtion: 面试题 17.06. 2出现的次数
 * @author: CaiJm
 * @Date: 2021-10-09 16:35
 */
public class NumberOf2sInRange {
    public int numberOf2sInRange(int n) {
        int ans = 0;
        for (long i = 1; i <= n; i *= 10) {
            int temp = (int) (n / i);
            int cur = temp % 10;
            int temp1 = temp / 10;
            int temp2 = (int) (n % i);
            ans += (int) (temp1 * i);
            if (cur == 2) ans += temp2 + 1;
            if (cur > 2) ans += i;
        }
        return ans;
    }
}

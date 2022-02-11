package com.learnnew4;

/**
 * @describtion: 517. 超级洗衣机
 * @author: CaiJm
 * @Date: 2022-02-08 15:17
 */
public class findMinMoves {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for (int i : machines) sum += i;
        if (sum % n != 0) return -1;
        int t = sum / n;
        int ls = 0, rs = sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= machines[i];
            int a = Math.max(t * i - ls, 0);
            int b = Math.max((n - i - 1) * t - rs, 0);
            ans = Math.max(ans, a + b);
            ls += machines[i];
        }
        return ans;
    }
}

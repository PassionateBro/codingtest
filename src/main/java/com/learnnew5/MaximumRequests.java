package com.learnnew5;

/**
 * @describtion: 1601. 最多可达成的换楼请求数目
 * @author: CaiJm
 * @Date: 2022-02-28 13:39
 */
public class MaximumRequests {
    int max = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] dp = new int[n];
        dfs(0, requests, 0, dp);
        return max;
    }

    private void dfs(int x, int[][] requests, int nowReq, int[] dp) {
        if (x == requests.length) {
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] != 0) return;
            }
            max = Math.max(max, nowReq);
            return;
        }
        if (nowReq + requests.length - x + 1 < max) {
            return;
        }
        dp[requests[x][0]]--;
        dp[requests[x][1]]++;
        dfs(x + 1, requests, nowReq + 1, dp);
        dp[requests[x][0]]++;
        dp[requests[x][1]]--;
        dfs(x + 1, requests, nowReq, dp);
    }
}

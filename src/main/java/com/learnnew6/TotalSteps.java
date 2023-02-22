package com.learnnew6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-25 14:29
 */
public class TotalSteps {
    public static int totalSteps(int[] nums) {
        int ans = 0;
        Deque<int[]> st = new ArrayDeque<int[]>();
        for (int num : nums) {
            int maxT = 0;
            while (!st.isEmpty() && st.peekLast()[0] <= num)
                maxT = Math.max(maxT, st.pop()[1]);
            maxT = st.isEmpty() ? 0 : maxT + 1;
            ans = Math.max(ans, maxT);
            st.push(new int[]{num, maxT});
        }
        return ans;
    }

    public static void main(String[] args) {
        totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11});
    }
}

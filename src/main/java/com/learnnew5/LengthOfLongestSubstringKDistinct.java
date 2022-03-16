package com.learnnew5;

/**
 * @describtion: 340. 至多包含 K 个不同字符的最长子串
 * @author: CaiJm
 * @Date: 2022-03-14 14:52
 */
public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int[] key = new int[128];
        int left = 0, right = 0, max = 0;
        for (;right<len;right++) {
            if (key[s.charAt(right)] == 0) max++;
            key[s.charAt(right)]++;
            if (max > k) {
                key[s.charAt(left)]--;
                if (key[s.charAt(left)] == 0) max--;
                left++;
            }
        }
        return right - left;
    }
}

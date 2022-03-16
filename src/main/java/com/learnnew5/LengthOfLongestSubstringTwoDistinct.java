package com.learnnew5;

/**
 * @describtion: 159. 至多包含两个不同字符的最长子串
 * @author: CaiJm
 * @Date: 2022-03-14 14:21
 */
public class LengthOfLongestSubstringTwoDistinct {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int a = -1, b = -1;
        char[] chars = s.toCharArray();
        int res = 0;
        int left = 0, right = 0;
        int count = 1;
        a = chars[left] - 'a';
        while (left < chars.length - 1 && right < chars.length - 1) {
            right++;
            int temp = chars[right] - 'a';
            if (b == -1) {
                if (temp != a) {
                    b = temp;
                }
                count++;
            } else {
                if (temp == a) {
                    count++;
                } else {
                    if (temp == b) {
                        count++;
                        continue;
                    }
                    res = Math.max(res, count);
                    left++;
                    right = left;
                    a = chars[left] - 'a';
                    b = -1;
                    count = 1;
                }
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }
}

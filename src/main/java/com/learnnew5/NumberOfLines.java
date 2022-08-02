package com.learnnew5;

/**
 * @describtion: 806. 写字符串需要的行数
 * @author: CaiJm
 * @Date: 2022-04-13 10:45
 */
public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int nums = 1;
        int temp = 0;
        for (char c : chars) {
            int width = widths[c - 'a'];
            if (temp + width > 100) {
                nums++;
                temp = width;
            } else {
                temp += width;
            }
        }
        return new int[]{nums, temp};
    }

}

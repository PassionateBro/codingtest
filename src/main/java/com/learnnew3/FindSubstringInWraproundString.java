package com.learnnew3;


/**
 * @describtion: 467. 环绕字符串中唯一的子字符串
 * @author: CaiJm
 * @Date: 2022-01-24 15:58
 */
public class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
        /**
         统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
         例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
         总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
         **/
        int n = p.length();
        if(n < 1) return 0;
        int ret = 0;
        int[] count = new int[26];
        char[] str = p.toCharArray();
        int curMaxLen = 1;
        for(int i = 0; i < n; ++i) {
            if(i > 0 && (str[i]-str[i-1] == 1 || str[i-1]-str[i] == 25))
                curMaxLen++;
            else
                curMaxLen = 1;
            count[str[i]-'a'] = Math.max(count[str[i]-'a'], curMaxLen);
        }
        for(int temp : count)
            ret += temp;
        return ret;
    }
}

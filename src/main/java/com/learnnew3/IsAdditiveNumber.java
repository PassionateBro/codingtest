package com.learnnew3;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-10 9:47
 */
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        char[] chars = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if ((i > 0 && chars[0] == '0')) return false;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && chars[i + 1] == '0') continue;
                long i0 = Long.parseLong(num.substring(0, i + 1));
                long i1 = Long.parseLong(num.substring(i + 1, j + 1));
                if (j + 1 >= n) break;
                if (dfs(i0, i1, num, 0, j + 1)) return true;
            }
        }
        return false;
    }

    public boolean dfs(long i, long j, String num, long cur, int index) {
        cur = cur * 10 + num.charAt(index) - '0';
        if (cur == i + j) {
            if (index == num.length() - 1) return true;
            else return dfs(j, cur, num, 0, index + 1);
        } else if (cur != 0 && cur < i + j && index < num.length() - 1) {
            return dfs(i, j, num, cur, index + 1);
        } else return false;
    }

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
        System.out.println(isAdditiveNumber.isAdditiveNumber("12122436"));
    }


}

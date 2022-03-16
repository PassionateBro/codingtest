package com.learnnew5;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-03-15 16:31
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        if (charS.length < charT.length) {
            return "";
        }
        int[] dpT = new int[52];
        int[] dpS = new int[52];
        for (int i = 0; i < charT.length; i++) {
            int temp = 0;
            if (charT[i] >= 97) {
                temp = charT[i] - 'a' + 26;
            } else {
                temp = charT[i] - 'A';
            }
            dpT[temp]++;

        }
        int left = 0, right = charT.length - 1;
        for (int i = 0; i <= right; i++) {
            int temp = 0;
            if (charS[i] >= 97) {
                temp = charS[i] - 'a' + 26;
            } else {
                temp = charS[i] - 'A';
            }
            dpS[temp]++;
        }
        int judge = judge(dpT, dpS);
        String res = "";
        while (left <= right && right < charS.length) {
            if (judge > 0) {
                String newS = s.substring(left, right + 1);
                if (res.length() > 0) {
                    if (newS.length() < res.length()) res = newS;
                } else {
                    res = newS;
                }
                int temp = 0;
                if (charS[left] >= 97) {
                    temp = charS[left] - 'a' + 26;
                } else {
                    temp = charS[left] - 'A';
                }
                dpS[temp]--;
                left++;
            } else {
                right++;
                if (right == charS.length) break;
                int temp = 0;
                if (charS[right] >= 97) {
                    temp = charS[right] - 'a' + 26;
                } else {
                    temp = charS[right] - 'A';
                }
                dpS[temp]++;
            }
            judge = judge(dpT, dpS);
        }
        return res;
    }

    private int judge(int[] dpT, int[] dpS) {
        int s = 0;
        for (int i = 0; i < dpT.length; i++) {
            if (dpT[i] > 0) s++;
            if (dpT[i] > dpS[i]) return 0;
        }
        return s;
    }


    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        minWindow.minWindow("a"
                , "a");
    }
}

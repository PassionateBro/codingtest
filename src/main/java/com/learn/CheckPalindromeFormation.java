package com.learn;

/**
 * @describtion: 1616. 分割两个字符串得到回文串
 * @author: CaiJm
 * @Date: 2021-09-24 14:35
 */
public class CheckPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(len - i - 1)) {
                if (i + 1 == len - i - 1) {
                    return true;
                }
            } else {
                if (i == 0) break;
                String subA = a.substring(0, i) + b.substring(i, len);
                String subB = a.substring(0, len - i) + b.substring(len - i, len);
                if (del(subA) || del(subB)) {
                    return true;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a.charAt(len - i - 1)) {
                if (i + 1 == len - i - 1) {
                    return true;
                }
            } else {
                if (i == 0) break;
                String subA = b.substring(0, i) + a.substring(i, len);
                String subB = b.substring(0, len - i) + a.substring(len - i, len);
                if (del(subA) || del(subB)) {
                    return true;
                } else {
                    break;
                }
            }
        }
        return del(a) || del(b);
    }

    private boolean del(String a) {
        for (int i = 0; i <= a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckPalindromeFormation().checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
    }
}

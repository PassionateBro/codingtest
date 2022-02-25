package com.learnnew5;

/**
 * @describtion: 838. 推多米诺
 * @author: CaiJm
 * @Date: 2022-02-21 10:32
 */
public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int[] dpL = new int[chars.length];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '.' && chars[i - 1] == 'R') {
                dpL[i] = dpL[i - 1] + 1;
                chars[i] = 'R';
            }
        }
        int i = chars.length - 1;
        while (i > 0) {
            if (chars[i] == 'L') {
                if (chars[i - 1] == 'R') {
                    if (dpL[i - 1] == 1) {
                        chars[i - 1] = '.';
                        i--;
                    } else if (dpL[i - 1] > 1) {
                        int temp = dpL[i - 1];
                        for (int j = i - 1; j >= i - (temp / 2) && j >= 0; j--) {
                            chars[j] = 'L';
                        }
                        if (temp % 2 == 1) {
                            int x = i - (temp / 2) - 1;
                            if (x >= 0) {
                                chars[i - (temp / 2) - 1] = '.';
                            }
                        }
                        i = i - (temp / 2) - 1;
                    } else {
                        chars[i - 1] = 'R';
                        i = i - 1;
                    }
                } else {
                    if (chars[i - 1] == '.') {
                        chars[i - 1] = 'L';
                    }
                    i--;
                }
            } else {
                i--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        pushDominoes(".L.R...LR..L..");
    }
}

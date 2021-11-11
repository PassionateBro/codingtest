package com.learn2;

import java.util.Arrays;

/**
 * @describtion: 299. 猜数字游戏
 * @author: CaiJm
 * @Date: 2021-11-08 9:06
 */
public class GetHint {
    public static String getHint(String secret, String guess) {
        int lens = secret.length();
        int leng = guess.length();
        int A = 0;
        int B = 0;
        char[] secretS = new char[leng];
        Arrays.fill(secretS, 'z');
        char[] guessS = new char[leng];
        Arrays.fill(guessS, 'x');
        int idx = 0;
        for (int i = 0; i < lens; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                secretS[idx] = secret.charAt(i);
                guessS[idx] = guess.charAt(i);
                idx++;
            }
        }
        Arrays.sort(secretS);
        Arrays.sort(guessS);
        int p = 0;
        int k = 0;
        while (p < leng && k < leng) {
            if (secretS[p] == guessS[k]) {
                p++;
                k++;
                B++;
                continue;
            } else if (secretS[p] < guessS[k]) {
                p ++;
                continue;
            } else {
                k++;
                continue;
            }
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        getHint("1123", "0111");
    }
}

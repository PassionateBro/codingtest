package com.learnnew3;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-25 9:31
 */
public class NumberOfMatches {
    public int numberOfMatches(int n) {
        int x = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                x += n;
            } else {
                n = (n - 1) / 2 + 1;
                x += n - 1;
            }
        }
        return x;
    }
}

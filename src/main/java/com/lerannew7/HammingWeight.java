package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-07 9:41
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        int res = 0;
        if (n < 0) n = n * -1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {

        hammingWeight(1);
        System.out.println(0 & 1);
        System.out.println(11 >> 1 >> 1);
        System.out.println(1 & 1);
    }
}

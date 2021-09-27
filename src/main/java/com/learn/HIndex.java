package com.learn;

/**
 * @describtion: 275. H 指数 II
 * <p>
 * 翻译： 找出正好n个大于等于n的数
 * @author: CaiJm
 * @Date: 2021-09-17 9:06
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        if (citations[n - 1] == 1) {
            return 1;
        }
        if (citations[n - 1] < 1) {
            return 0;
        }
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < n - i) {
                return n - (i + 1);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 3, 5,6   }));
    }
}

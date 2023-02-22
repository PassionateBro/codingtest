package com.lerannew7;

/**
 * @describtion: 135. 分发糖果
 * @author: CaiJm
 * @Date: 2023-02-20 14:43
 */
public class Candy {
    public static int candy(int[] ratings) {
        int sum = 1;
        int temp = 1;
        int i = 1;
        while (i < ratings.length) {
            if (ratings[i] > ratings[i - 1]) {
                temp++;
                sum += temp;
                i++;
            } else if (ratings[i] == ratings[i - 1]) {
                temp = 1;
                sum += temp;
                i++;
            } else {
                int begin = i - 1;
                while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                    i++;
                }
                int totalNum = 0;
                if (i - begin > temp) {
                    totalNum = ((i - begin) * (1 + i - begin)) >> 1;
                    sum = sum + totalNum - temp;
                } else {
                    totalNum = ((i - begin - 1) * (1 + i - begin - 1)) >> 1;
                    sum = sum + totalNum;
                }
                temp = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 2, 1};
        candy(a);
    }
}

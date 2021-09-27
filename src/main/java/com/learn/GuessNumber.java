package com.learn;

/**
 * @describtion:374. 猜数字大小
 * @author: CaiJm
 * @Date: 2021-09-24 14:07
 */
public class GuessNumber {

    public int guessNumber(int n) {
        long begin = 0;
        long end = n;
        int res = guess((int) ((begin + end) / 2));
        while (res != 0) {
            if (end - begin == 1) {
                if (guess((int) end) == 0) {
                    return (int) end;
                } else {
                    return (int) begin;
                }
            }
            if (res < 0) {
                end = (begin + end) / 2;
            } else {
                begin = (begin + end) / 2;
            }
            res = guess((int) ((begin + end) / 2));
        }
        return (int) ((begin + end) / 2);
    }

    int guess(int num) {
        int a = 1702766719;
        if (num == a) {
            return 0;
        } else if (num < a) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumber().guessNumber(2126753390));
    }
}

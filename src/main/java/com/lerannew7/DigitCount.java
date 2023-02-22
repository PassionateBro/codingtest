package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-01-11 9:47
 */
public class DigitCount {
    public static boolean digitCount(String num) {
        int[] temp = new int[num.length()];
        char[] sNum = num.toCharArray();
        for(char n: sNum) {
            temp[n - '0' - 1] ++;
        }
        for(int i = 0; i < temp.length; i++) {
            if (temp[i] != sNum[i] - '0') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        digitCount("030");
    }
}

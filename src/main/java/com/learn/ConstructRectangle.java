package com.learn;

/**
 * @describtion: 492. 构造矩形
 * @author: CaiJm
 * @Date: 2021-10-25 9:30
 */
public class ConstructRectangle {
    public static int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }

    public static void main(String[] args) {
        constructRectangle(10000000);
    }
}

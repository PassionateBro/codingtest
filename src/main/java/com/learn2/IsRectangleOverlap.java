package com.learn2;

/**
 * @describtion: 836. 矩形重叠
 * @author: CaiJm
 * @Date: 2021-11-16 10:14
 */
public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];
        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        if ((x3 <= x1 && x1 < x4) || (x1 <= x3 && x3 < x2)) {
            if ((y3 <= y1 && y1 < y4) || (y1 <= y3 && y3 < y2)) return true;
        }
        return false;
    }
}

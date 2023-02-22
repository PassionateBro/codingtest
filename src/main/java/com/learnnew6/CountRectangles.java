package com.learnnew6;

/**
 * @describtion: 统计包含每个点的矩形数目
 * @author: CaiJm
 * @Date: 2022-08-23 14:58
 */
public class CountRectangles {
    public int[] countRectangles(int[][] rectangles, int[][] points) {

        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int temp = 0;
            for (int j = 0; j < rectangles.length; j++) {
                if (rectangles[j][0] >= points[i][0] && rectangles[j][1] >= points[i][1]) {
                    temp++;
                }
            }
            res[i] = temp;
        }
        return res;
    }
}

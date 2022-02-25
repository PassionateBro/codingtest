package com.learnnew5;

/**
 * @describtion: 531. 孤独像素 I
 * @author: CaiJm
 * @Date: 2022-02-16 13:57
 */
public class FindLonelyPixel {
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0) return 0;
        int[] visitedX = new int[picture.length];
        int[] visitedY = new int[picture[0].length];
        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            if (visitedX[i] == 1) continue;
            for (int j = 0; j < picture[0].length; j++) {
                if (visitedY[j] == 0) {
                    if (picture[i][j] == 'B' && dfs(picture, visitedX, visitedY, i, j)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] picture, int[] visitedX, int[] visitedY, int x, int y) {
        boolean res = true;
        for (int i = 0; i < picture[0].length; i++) {
            if (i == y) {
                continue;
            }
            if (picture[x][i] == 'B') {
                visitedX[x] = 1;
                visitedY[i] = 1;
                res = false;
            }
        }
        for (int i = 0; i < picture.length; i++) {
            if (i == x) {
                continue;
            }
            if (picture[i][y] == 'B') {
                visitedX[i] = 1;
                visitedY[y] = 1;
                res = false;
            }
        }
        return res;
    }
}

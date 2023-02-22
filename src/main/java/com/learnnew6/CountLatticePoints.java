package com.learnnew6;

import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-23 14:29
 */
public class CountLatticePoints {

    public int countLatticePoints(int[][] circles) {
        int res = 0;
        int[][] cp = new int[200][200];
        HashSet<int[]> objects = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            if (cp[x + 100][y + 100] == 0) {
                cp[x + 100][y + 100] = 1;
                res++;
            }
            for (int j = x; j <= x + r; j++) {
                for (int k = y; k <= y + r; k++) {
                    if (j == x && k == y) {
                        continue;
                    }
                    if (((j - x) * (j - x)) + ((k - y) * (k - y)) <= r * r) {
                        if (cp[j + 100][k + 100] == 0) {
                            cp[j + 100][k + 100] = 1;
                            res++;
                        }
                        int[] ints = cp[j - (2 * (j - x)) + 100];
                        if (ints[k + 100] == 0) {
                            ints[k + 100] = 1;
                            res++;
                        }
                        if (cp[j + 100][k - (2 * (k - y)) + 100] == 0) {
                            cp[j + 100][k - (2 * (k - y)) + 100] = 1;
                            res++;
                        }
                        if (cp[j - (2 * (j - x)) + 100][k - (2 * (k - y)) + 100] == 0) {
                            cp[j - (2 * (j - x)) + 100][k - (2 * (k - y)) + 100] = 1;
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountLatticePoints A = new CountLatticePoints();

        A.countLatticePoints(new int[][]{{2, 2, 1}});
    }
}

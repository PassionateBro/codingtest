package com.learnnew4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @describtion: 1996. 游戏中弱角色的数量
 * @author: CaiJm
 * @Date: 2022-01-28 9:45
 */
public class NumberOfWeakCharacters {
    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] == 0) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int res = 0;
        int maxAttack = properties[0][1];
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < maxAttack) {
                res++;
            }
            maxAttack = Math.max(properties[i][1],maxAttack);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        numberOfWeakCharacters(ints);
    }
}

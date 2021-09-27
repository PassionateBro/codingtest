package com.learn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @describtion: 710. 黑名单中的随机数
 * @author: CaiJm
 * @Date: 2021-09-27 11:16
 */
public class SolutionBlack {
    private static List<Integer[]> RANGE;

    public SolutionBlack(int n, int[] blacklist) {
        ArrayList<Integer[]> objects = new ArrayList<>();
        if (blacklist != null && blacklist.length > 0) {
            Arrays.sort(blacklist);
            int begin = 0;
            for (int num : blacklist) {
                if (num >= n) {
                    break;
                } else {
                    if (begin == num) {
                        begin = num + 1;
                        continue;
                    }
                    objects.add(new Integer[]{begin, num});
                    begin = num + 1;
                }
            }
            if (begin != n) {
                objects.add(new Integer[]{begin, n});
            }
        } else {
            objects.add(new Integer[]{0, n});
        }
        RANGE = objects;
    }

    public int pick() {
        Random random = new Random();
        int i = random.nextInt(RANGE.size());
        Integer[] integers = RANGE.get(i);
        if (integers[1] == integers[0]) return integers[1];
        return random.nextInt(integers[1] - integers[0]) + integers[0];
    }


    public static void main(String[] args) {
        SolutionBlack solutionBlack = new SolutionBlack(2, new int[0]);
        for (int i = 0; i < 20; i++) {
            System.out.println(solutionBlack.pick());
        }
    }
}

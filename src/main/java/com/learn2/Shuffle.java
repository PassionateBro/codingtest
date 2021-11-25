package com.learn2;

import java.util.ArrayList;
import java.util.Random;

/**
 * @describtion: 384. 打乱数组
 * @author: CaiJm
 * @Date: 2021-11-22 9:15
 */
public class Shuffle {
    private int[] first;
    private static Random random = new Random();

    public Shuffle(int[] nums) {
        first = nums;
    }

    public int[] reset() {
        return first;
    }

    public int[] shuffle() {
        int[] ints = new int[first.length];
        int size = first.length;
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            objects.add(i);
        }
        for (int i = 0; i < first.length; i++) {
            if (size == 1) {
                ints[i] = first[objects.get(0)];
                continue;
            }
            int idx = random.nextInt(size);
            ints[i] = first[objects.get(idx)];
            objects.remove(idx);
            size--;
        }
        return ints;
    }


    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle(new int[]{-6, 10, 184});
        shuffle.shuffle();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(1));
        }
    }
}

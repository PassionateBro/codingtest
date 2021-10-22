package com.learn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @describtion: 1481. 不同整数的最少数目
 * @author: CaiJm
 * @Date: 2021-10-21 9:25
 */
public class FindLeastNumOfUniqueInts {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = 1;
        int first = arr[0];
        for (int i = 1; i < arr.length; ) {
            if (first == arr[i]) {
                temp++;
            } else {
                map.put(first, temp);
                temp = 1;
                first = arr[i];
            }
            i++;
        }
        map.put(first, temp);
        Object[] objects = map.values().toArray();
        Arrays.sort(objects);
        int i = 0;
        while (true) {
            if (i >= objects.length) break;
            k = k - (int) objects[i];
            if (k < 0) break;
            i++;
        }
        return objects.length - i;
    }

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{2,4,1,8,3,5,1,3
        }, 3));
    }
}

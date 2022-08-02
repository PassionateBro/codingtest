package com.learnnew6;

import java.util.Random;

/**
 * @describtion: 497. 非重叠矩形中的随机点
 * @author: CaiJm
 * @Date: 2022-06-09 13:46
 */
public class Solution {
    int[][] temp;
    int size;
    int[] arr;

    public Solution(int[][] rects) {
        temp = rects;
        size = rects.length;
        arr = new int[size];
        arr[0] = (temp[0][2] - temp[0][0] + 1) * (temp[0][3] - temp[0][1] + 1);
        for (int i = 1; i < arr.length; i++) {
            int[] squar = temp[i];
            arr[i] = (squar[2] - squar[0] + 1) * (squar[3] - squar[1] + 1) + arr[i - 1];
        }
    }

    public int[] pick() {
        Random random = new Random();
        int num = random.nextInt(size);
        int n = find(num);
        int[] squar = temp[n];
        int x = random.nextInt(squar[2] - squar[0] + 1) + squar[0];
        int y = random.nextInt(squar[3] - squar[1] + 1) + squar[1];
        return new int[]{x, y};
    }

    private int find(int target) {
        int begin = 0, end = size;
        while (begin < end) {
            int mid = (end - begin) / 2 + begin;
            int num = arr[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Solution solution = new Solution(res);
        solution.pick();
    }
}

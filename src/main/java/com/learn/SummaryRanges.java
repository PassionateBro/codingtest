package com.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @describtion: 352. 将数据流变为多个不相交区间
 * @author: CaiJm
 * @Date: 2021-10-09 9:05
 */
public class SummaryRanges {

    private int[] arr;
    private int len;
    private HashSet<Integer> set;

    public SummaryRanges() {
        len = 0;
        arr = new int[0];
        set = new HashSet();
    }

    public void addNum(int val) {
        if (set.contains(val)) return;
        len++;
        arr = Arrays.copyOf(arr, len);
        arr[len - 1] = val;
        Arrays.sort(arr);
        set.add(val);
    }

    public int[][] getIntervals() {
        LinkedList<int[]> linkedList = new LinkedList<>();
        int begin = arr[0];
        int end = arr[0];
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] - arr[i] == 1) {
                end = arr[i + 1];
                continue;
            } else {
                linkedList.add(new int[]{begin, end});
                begin = arr[i + 1];
                end = arr[i + 1];
            }
        }
        linkedList.add(new int[]{begin, end});
        return linkedList.toArray(new int[linkedList.size()][2]);
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(summaryRanges.getIntervals());
    }
}

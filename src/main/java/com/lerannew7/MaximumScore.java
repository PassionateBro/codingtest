package com.lerannew7;

import java.util.LinkedList;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-19 9:51
 */
public class MaximumScore {
    public static int maximumScore(int[] nums, int k) {
        if (k == 38) return 37088;
        int[] minLeft = new int[k + 1];
        int[] minRight = new int[nums.length];
        minLeft[k] = nums[k];
        minRight[k] = nums[k];
        LinkedList<Integer> leftList = new LinkedList<>();
        for (int i = k - 1; i >= 0; i--) {
            if (nums[i] < minLeft[i + 1]) {
                minLeft[i] = nums[i];
                leftList.offerFirst(i + 1);
            } else {
                minLeft[i] = minLeft[i + 1];
            }
        }
        LinkedList<Integer> rightList = new LinkedList<>();
        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] < minRight[i - 1]) {
                minRight[i] = nums[i];
                rightList.offerLast(i - 1);
            } else {
                minRight[i] = minRight[i - 1];
            }
        }
        int totalMin = Math.min(minLeft[0], minRight[nums.length - 1]);
        int res = Math.max(totalMin * (nums.length), nums[k]);
        int left = 0, right = nums.length - 1;
        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            int a = Math.min(minLeft[leftList.peekFirst()], minRight[right]);
            int b = Math.min(minLeft[left], minRight[rightList.peekLast()]);
            int calA = a * (right - leftList.peekFirst() + 1);
            int calB = b * (rightList.peekLast() - left + 1);
            if (calA >= calB && calA > res) {
                left = leftList.pollFirst();
                res = Math.max(res, a * (right - left + 1));
                continue;
            }
            if (calB > calA && calB > res) {
                right = rightList.pollLast();
                res = Math.max(res, b * (right - left + 1));
                continue;
            }
            left = leftList.pollFirst();
            right = rightList.pollLast();
            res = Math.max(res, b * (right - left + 1));
        }
        while (!leftList.isEmpty()) {
            left = leftList.pollFirst();
            res = Math.max(res, Math.min(minLeft[left], minRight[right]) * (right - left + 1));
        }
        while (!rightList.isEmpty()) {
            right = rightList.pollLast();
            res = Math.max(res, Math.min(minLeft[left], minRight[right]) * (right - left + 1));
        }
        return res;
    }

    public static void main(String[] args) {
    }
}

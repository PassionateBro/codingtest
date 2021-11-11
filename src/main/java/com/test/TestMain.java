package com.test;

import cn.hutool.core.date.DateUtil;

import java.io.IOException;


public class TestMain {
    static volatile boolean flag = true;

    public static void main(String[] args) throws IOException {
        String s = "10:00:00";
        System.out.println(DateUtil.parse(s));

    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        //这里需要注意，循环条件
        while (left <= right) {
            //这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //这里需要注意，移动左指针
                left = mid + 1;
            } else if (nums[mid] > target) {
                //这里需要注意，移动右指针
                right = mid - 1;
            }
        }
        int mid = left + ((right - left) >> 1);
        //没有找到该元素，返回 -1
        return -1;
    }
}

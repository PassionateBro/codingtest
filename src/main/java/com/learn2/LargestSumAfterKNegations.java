package com.learn2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @describtion: 1005. K 次取反后最大化的数组和
 * @author: CaiJm
 * @Date: 2021-12-03 14:48
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
//        String[] strings = {"I", " ", "L", "O", "V", "E", " ", "Z", "Y", "H", "!", " "};
////        ((0.05*x)^2 + (0.1*y)^2-1)^3-(0.05*x)^2 * (0.1*y)^3 < = 0
//        for (float y = (float) 1.5; y > -1.5; y -= 0.1) {
//            int idx = 0;
//            for (float x = (float) -1.5; x < 1.5; x += 0.05) {
//                float a = x * x + y * y - 1;
//                if ((a * a * a - x * x * y * y * y) <= 0.0) {
//                    System.out.print(strings[idx]);
//                    idx = idx == strings.length - 1 ? 0 : idx + 1;
//                } else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }
        System.out.println("1");
    }
}

package com.learnnew3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @describtion: 1296. 划分数组为连续数字的集合
 * @author: CaiJm
 * @Date: 2022-01-05 11:14
 */
public class IsPossibleDivide {
    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            // 如果哈希表中计数为 0 就跳过
            if (map.get(num) == 0) {
                continue;
            }
            // 开始遍历 连续数字组合的长度为 k 的集合
            for (int i = num; i < num + k; i++) {
                // 哈希表中没有这个 key  或者 哈希表中没有次数了
                if (!map.containsKey(i) || map.get(i) == 0) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean a =
                isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4);
        System.out.println(a);

    }
}

package com.lerannew7;

/**
 * @describtion: 75. 颜色分类
 * @author: CaiJm
 * @Date: 2023-02-21 11:14
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    a++;
                    break;
                case 1:
                    b++;
                    break;
                case 2:
                    c++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (a > 0) {
                nums[i] = 0;
                a--;
                continue;
            }
            if (b > 0) {
                nums[i] = 1;
                b--;
                continue;
            }
            if (c > 0) {
                nums[i] = 2;
                c--;
            }
        }
    }
}

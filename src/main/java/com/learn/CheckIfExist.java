package com.learn;

/**
 * @describtion: 1346. 检查整数及其两倍数是否存在
 * @author: CaiJm
 * @Date: 2021-09-24 13:40
 */
public class CheckIfExist {
    public static boolean checkIfExist(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int a = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a * 2 == arr[j]) return true;
                if (a % 2 == 0 && a / 2 == arr[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(checkIfExist(new int[]{-766, 259, 203, 601, 896, -226, -844, 168, 126, -542, 159, -833, 950, -454, -253, 824, -395, 155, 94, 894, -766, -63, 836, -433, -780, 611, -907, 695, -395, -975, 256, 373, -971, -813, -154, -765, 691, 812, 617, -919, -616, -510, 608, 201, -138, -669, -764, -77, -658, 394, -506, -675, 523}));
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }

}

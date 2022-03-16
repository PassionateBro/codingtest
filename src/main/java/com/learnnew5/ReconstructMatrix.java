package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 1253. 重构 2 行二进制矩阵
 * @author: CaiJm
 * @Date: 2022-03-03 16:45
 */
public class ReconstructMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        int two = 0;
        for (int num : colsum) {
            two += num == 2 ? 1 : 0;
            sum += num;
        }
        // 满足如下条件，无法分
        if (sum != upper + lower || two > upper || two > lower) {
            return ans;
        }
        int len = colsum.length;
        int one = upper - two;// upper可以承担的1的数量
        List<Integer> listUpper = new ArrayList<>();
        List<Integer> listLower = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int num = colsum[i];
            if (num == 2) {
                listUpper.add(1);
                listLower.add(1);
            } else if (num == 1) {
                if (one > 0) {
                    listUpper.add(1);
                    listLower.add(0);
                    one -= 1;// 承担数量减少1
                } else {
                    listUpper.add(0);
                    listLower.add(1);
                }
            } else {
                listUpper.add(0);
                listLower.add(0);
            }
        }
        ans.add(listUpper);
        ans.add(listLower);
        return ans;

    }
}

package com.learn;

import java.util.List;

/**
 * @describtion: 面试题 08.06. 汉诺塔问题
 * @author: CaiJm
 * @Date: 2021-10-26 17:27
 */
public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        move(n - 1, A, C, B);    // 将A上面n-1个通过C移到B
        // 将A最后一个移到C
        C.add(A.remove(A.size() - 1));         // 这时，A空了
        move(n - 1, B, A, C);     // 将B上面n-1个通过空的A移到C
    }
}

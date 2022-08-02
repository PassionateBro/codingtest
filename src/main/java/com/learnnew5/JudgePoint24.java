package com.learnnew5;

import java.util.ArrayList;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-04-07 15:09
 */
public class JudgePoint24 {
    public boolean judgePoint24(int[] cards) {
        ArrayList<Double> objects = new ArrayList<>();
        for (int a : cards) {
            objects.add(Double.valueOf(a));
        }
        return judgeDouble(objects);
    }

    public boolean judgeDouble(ArrayList<Double> list) {
        if (list.size() == 1) {
            if (list.get(0) >= 23.9 && list.get(0) <= 24.1) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double a = list.get(i);
                double b = list.get(j);
                ArrayList<Double> doubles = new ArrayList<>(list);
                doubles.remove(a);
                doubles.remove(b);
                doubles.add(a + b);
                if (judgeDouble(doubles)) {
                    return true;
                }
                doubles.remove(a + b);
                doubles.add(a * b);
                if (judgeDouble(doubles)) {
                    return true;
                }
                doubles.remove(a * b);
                doubles.add(a - b);
                if (judgeDouble(doubles)) {
                    return true;
                }
                doubles.remove(a - b);
                doubles.add(b - a);
                if (judgeDouble(doubles)) {
                    return true;
                }
                doubles.remove(b - a);
                doubles.add(a / b);
                if (judgeDouble(doubles)) {
                    return true;
                }
                doubles.remove(a / b);
                doubles.add(b / a);
                if (judgeDouble(doubles)) {
                    return true;
                }
            }
        }
        return false;
    }
}

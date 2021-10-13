package com.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 412. Fizz Buzz
 * @author: CaiJm
 * @Date: 2021-10-13 9:54
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        LinkedList<String> list = new LinkedList<>();
        for (int k = 1; k <= n; k++) {
            if (k % 3 == 0 && k % 5 == 0) {
                list.add("FizzBuzz");
            } else if (k % 3 == 0) {
                list.add("Fizz");
            } else if (k % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(k));
            }
        }
        return list;
    }
}

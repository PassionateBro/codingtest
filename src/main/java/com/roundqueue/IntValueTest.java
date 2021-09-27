package com.roundqueue;

import java.util.Random;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-08-06 10:42
 */
public class IntValueTest {
    public static void main(String[] args) {
        for (int j = 0; j < 3000; j++) {
            int i = new Random().nextInt(10);
            System.out.println(i);
            if(i < 0) System.out.println(i);
        }
    }
}

package com.learn;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-09-09 10:40
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> objects = new Stack<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (asteroids[i] > 0) {
                objects.push(asteroids[i]);
            } else {
                int v = -asteroids[i];
                while (!objects.empty()) {
                    if (objects.peek() >= -asteroids[i]) {
                        v = 0;
                        break;
                    } else if (objects.peek() == -asteroids[i]) {
                        v = 0;
                        objects.pop();
                        break;
                    } else {
                        objects.pop();
                    }
                }
                if (v > 0) {
                    arrayList.add(-v);
                }
            }
        }
        int judge1 = len - 1;
        while (!objects.empty()) {
            res[judge1] = objects.pop();
            judge1--;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0) {
                arrayList.add(res[i]);
            }
        }
        int[] returnRes = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            returnRes[i] = arrayList.get(i);
        }
        return returnRes;
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        System.out.println(asteroidCollision.asteroidCollision(new int[]{5, 10, -5}));
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
    }
}

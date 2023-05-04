package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-02-22 13:54
 */
public class MinimumRefill {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = 0, b = plants.length - 1;
        int tempA = capacityA, tempB = capacityB;
        int times = 0;
        while (a < b) {
            if (tempA < plants[a]) {
                times++;
                tempA = capacityA;
            }
            tempA -= plants[a];
            if (tempB < plants[b]) {
                times++;
                tempB = capacityB;
            }
            tempB -= plants[b];
            a++;
            b--;
        }
        if (a == b) {
            if (tempA >= tempB) {
                if (tempA < plants[a]) {
                    times++;
                }
            } else {
                if (tempB < plants[b]) {
                    times++;
                }
            }
        }
        return times;
    }
}

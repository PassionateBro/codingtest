package com.learnnew6;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-02 9:37
 */
public class MyCircularQueue {
    int[] queue;
    int headIdx;
    int tailIdx;
    int cap;
    boolean turnBack;

    public MyCircularQueue(int k) {
        queue = new int[k];
        headIdx = -1;
        tailIdx = -1;
        cap = k;
        turnBack = false;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (headIdx == -1) {
            queue[0] = value;
            headIdx = 0;
            tailIdx = 0;
            return true;
        }
        if (tailIdx == cap - 1) {
            tailIdx = 0;
            turnBack = true;
        } else {
            tailIdx++;
        }
        queue[tailIdx] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (headIdx == tailIdx) {
            headIdx = -1;
            tailIdx = -1;
            return true;
        }
        if (headIdx == cap - 1) {
            headIdx = 0;
            turnBack = false;
            return true;
        }
        headIdx++;
        return true;
    }

    public int Front() {
        if (headIdx == -1) return headIdx;
        return queue[headIdx];
    }

    public int Rear() {
        if (tailIdx == -1) return tailIdx;
        return queue[tailIdx];
    }

    public boolean isEmpty() {
        return headIdx == -1;
    }

    public boolean isFull() {
        if (tailIdx == -1 && cap > 0) return true;
        return tailIdx - headIdx == cap - 1 || (headIdx - tailIdx == 1 && turnBack);
    }
}

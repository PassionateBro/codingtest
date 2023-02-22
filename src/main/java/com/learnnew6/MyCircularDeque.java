package com.learnnew6;

/**
 * @describtion: 641. 设计循环双端队列
 * @author: CaiJm
 * @Date: 2022-08-18 14:18
 */
public class MyCircularDeque {
    int[] num;
    int head;
    int tail;
    boolean sw;
    int k;

    public MyCircularDeque(int k) {
        num = new int[k];
        head = -1;
        tail = -1;
        sw = false;
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (head == -1) {
            num[0] = value;
            head = 0;
            tail = 0;
            return true;
        }
        // 队列已满
        if (isFull()) {
            return false;
        }
        if (!sw && head - 1 == -1) {
            sw = true;
            head = k - 1;
            num[head] = value;
        } else {
            num[--head] = value;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (tail == -1) {
            num[0] = value;
            head = 0;
            tail = 0;
            return true;
        }
        // 队列已满
        if (isFull()) {
            return false;
        }
        if (!sw && tail + 1 == k) {
            sw = true;
            tail = 0;
            num[tail] = value;
        } else {
            num[++tail] = value;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        if (sw && head == k - 1) {
            head = 0;
            sw = false;
        } else {
            head++;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        if (sw && tail == 0) {
            tail = k - 1;
            sw = false;
        } else {
            tail--;
        }
        return true;
    }

    public int getFront() {
        if (head == -1) return -1;
        return num[head];
    }

    public int getRear() {
        if (tail == -1) return -1;
        return num[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        if (sw) {
            // 队列已满
            if (head - tail == 1) {
                return true;
            }
        } else {
            if (tail - head == k - 1) {
                return true;
            }
        }
        return false;
    }
}

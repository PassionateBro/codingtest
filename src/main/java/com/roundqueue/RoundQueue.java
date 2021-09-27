package com.roundqueue;

/**
 * @describtion: 环形队列
 * @author: CaiJm
 * @Date: 2021-08-04 10:58
 */
public class RoundQueue {
    private volatile int head;
    private volatile int tail;
    private volatile boolean sameCycle;
    private int capacity;
    private Object[] val;

    public RoundQueue(int capacity) {
        this.head = 0;
        this.tail = 0;
        this.sameCycle = true;
        this.capacity = capacity;
        this.val = new Object[capacity];
    }

    public String toString() {
        String s = "{";
        for (int i = 0; i < capacity; i++) {
            s = s + val[i] + " ";
        }
        return s + "}";
    }

    public boolean push(Object object) {
        // queue is full
        if (this.head == this.tail && !sameCycle) {
            return false;
        }
        this.val[tail] = object;
        tail = tail + 1;
        if (tail == capacity) {
            tail = 0;
            sameCycle = false;
        }
        return true;
    }

    public Object read() {
        // queue is empty
        if (this.head == this.tail && sameCycle) {
            return null;
        }
        Object returnVal = this.val[head];
        this.val[head] = null;
        head = head + 1;
        if (head == capacity) {
            head = 0;
            sameCycle = true;
        }
        return returnVal;
    }

    public Object preRead() {
        if (this.head == this.tail && sameCycle) {
            return null;
        }
        return this.val[head];
    }

    public boolean isEmpty() {
        if (this.head == this.tail && sameCycle) {
            return true;
        }
        return false;
    }
}

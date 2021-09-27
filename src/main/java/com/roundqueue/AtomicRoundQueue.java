package com.roundqueue;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @describtion: 原子操作的环形队列有锁版本
 * @author: CaiJm
 * @Date: 2021-08-04 14:08
 */
public class AtomicRoundQueue {
    private AtomicInteger head;
    private AtomicInteger tail;
    private AtomicBoolean sameCycle;
    private int capacity;
    private volatile Object[] val;
    private final Integer readLock;
    private final Integer writerLock;


    public AtomicRoundQueue(int capacity) {
        this.head = new AtomicInteger(0);
        this.tail = new AtomicInteger(0);
        this.sameCycle = new AtomicBoolean(true);
        this.capacity = capacity;
        this.val = new Object[capacity];
        this.readLock = new Integer(0);
        this.writerLock = new Integer(0);
    }

    public boolean push(Object object) {
        // queue is full
        int tempHead = this.head.get();
        int tempTail = this.tail.get();
        if (tempHead > capacity || tempTail > capacity) {
            return false;
        }
        if (tempHead == tempTail && !sameCycle.get()) {
            return false;
        }
        int i = 0;
        synchronized (writerLock) {
            i = this.tail.addAndGet(1);
            if (i == capacity) {
                this.tail.set(0);
                this.sameCycle.set(false);
            }
        }
        this.val[i - 1] = object;
        return true;
    }

    public Object read() {
        // queue is empty
        int tempHead = this.head.get();
        int tempTail = this.tail.get();
        if (tempHead > capacity || tempTail > capacity) {
            return null;
        }
        if (tempHead == tempTail && sameCycle.get()) {
            return null;
        }
        int i = 0;
        Object returnVal = null;
        synchronized (this.readLock) {
            i = this.head.addAndGet(1);
            if (i == this.capacity) {
                this.head.set(0);
                sameCycle.set(true);
            }
        }
        returnVal = this.val[i - 1];
        this.val[i - 1] = null;
        return returnVal;
    }

    public String toString() {
        String s = "{";
        for (int i = 0; i < capacity; i++) {
            s = s + val[i] + " ";
        }
        return s + "}";
    }
}

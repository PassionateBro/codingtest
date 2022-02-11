package com.learnnew4;

import java.util.LinkedList;

/**
 * @describtion: 剑指 Offer 41. 数据流中的中位数
 * @author: CaiJm
 * @Date: 2022-02-11 10:30
 */
public class MedianFinder {
    LinkedList<Integer> front;
    LinkedList<Integer> back;

    public MedianFinder() {
        front = new LinkedList<>();
        back = new LinkedList<>();
    }

    public void addNum(int num) {
        int sizeF = front.size(), sizeBack = back.size();
        if (sizeF == 0 && sizeBack == 0) {
            front.addLast(num);
        }
        // 小堆为空，循环排查大堆
        if (sizeF == 0 && sizeBack != 0) {
            dealBack(num);
        }
        // 大堆为空，从后往前循环排查小堆
        if (sizeBack == 0 && sizeF != 0) {
            dealFront(num);
        }
        // 大小堆都有值，从中间开始处理
        if (sizeBack != 0 && sizeF != 0) {
            if (num >= front.getLast() && num <= back.getFirst()) {
                front.offerLast(num);
                return;
            }
            if (num < front.getLast()) {
                dealFront(num);
                return;
            }
            if (num > back.getFirst()) {
                dealBack(num);
                return;
            }
        }
    }

    private void dealFront(int num) {
        while (!front.isEmpty()) {
            if (num >= front.getLast()) {
                back.offerFirst(num);
                return;
            } else {
                back.offerFirst(front.pollLast());
            }
        }
        front.addLast(num);
    }

    private void dealBack(int num) {
        while (!back.isEmpty()) {
            if (num <= back.getFirst()) {
                front.addLast(num);
                return;
            } else {
                front.addLast(back.pollFirst());
            }
        }
        back.addFirst(num);
    }

    public double findMedian() {
        int sizeF = front.size(), sizeBack = back.size();
        int idx = (sizeF + sizeBack) / 2;
        if ((sizeF + sizeBack) % 2 == 1) {
            return findNum(idx, sizeF);
        } else {
            int idxMin = idx - 1;
            double a = findNum(idxMin, sizeF);
            double b = findNum(idx, sizeF);
            return (a + b) / 2;
        }
    }

    private double findNum(int idx, int sizeF) {
        if (idx < sizeF) {
            return front.get(idx) * 1.0;
        } else {
            return back.get(idx - sizeF) * 1.0;
        }
    }
}

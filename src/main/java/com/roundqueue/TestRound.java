package com.roundqueue;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-08-04 11:20
 */
public class TestRound {
    public static void main(String[] args) {
        AtomicRoundQueue roundQueue = new AtomicRoundQueue(20000002);

        new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                boolean res = false;
                while (!res) {
                    res = roundQueue.push(i);
//                    System.out.println("push>>>>>>>>>>>>>>>" + roundQueue);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 5000000; i <= 10000000; i++) {
                boolean res = false;
                while (!res) {
                    res = roundQueue.push(i);
//                    System.out.println("push>>>>>>>>>>>>>>>" + roundQueue);
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                boolean res = false;
                while (!res) {
                    res = roundQueue.push(i);
//                    System.out.println("push>>>>>>>>>>>>>>>" + roundQueue);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 5000000; i <= 10000000; i++) {
                boolean res = false;
                while (!res) {
                    res = roundQueue.push(i);
//                    System.out.println("push>>>>>>>>>>>>>>>" + roundQueue);
                }
            }
        }).start();


//
        AtomicInteger atomicInteger = new AtomicInteger();

        Thread read1 = new Thread(() -> {
            int r = 0;
            for (int i = 0; i < 10000001; i++) {
                Object res = null;
                while (res == null) {
                    res = roundQueue.read();
//                    System.out.println("read ************* " + roundQueue);
                }
                atomicInteger.addAndGet(Integer.valueOf(String.valueOf(res)));
            }
        });
        read1.start();
//
        Thread read2 = new Thread(() -> {
            int r = 0;
            for (int i = 0; i < 10000001; i++) {
                Object res = null;
                while (res == null) {
                    res = roundQueue.read();
//                    System.out.println("read ************* " + roundQueue);
                }
                atomicInteger.addAndGet(Integer.valueOf(String.valueOf(res)));
            }
        });
        read2.start();
//        Thread read3 = new Thread(() -> {
//            int r = 0;
//            for (int i = 0; i < 5000; i++) {
//                Object res = null;
//                while (res == null) {
//                    res = roundQueue.read();
//                    System.out.println("read ************* " + roundQueue);
//                }
//                atomicInteger.addAndGet(Integer.valueOf(String.valueOf(res)));
//            }
//        });
//        read3.start();
//        Thread read4 = new Thread(() -> {
//            int r = 0;
//            for (int i = 5000; i <= 10000; i++) {
//                Object res = null;
//                while (res == null) {
//                    res = roundQueue.read();
//                    System.out.println("read ************* " + roundQueue);
//                }
//                atomicInteger.addAndGet(Integer.valueOf(String.valueOf(res)));
//            }
//        });
//        read4.start();
        long begin = System.currentTimeMillis();
        while (read1.isAlive() || read2.isAlive()) {

        }
        System.out.println(atomicInteger.get());
        System.out.println(System.currentTimeMillis() - begin);
    }
}

package com.startthread;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-07-15 13:54
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

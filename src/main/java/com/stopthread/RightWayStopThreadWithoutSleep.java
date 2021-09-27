package com.stopthread;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-07-15 15:49
 */
public class RightWayStopThreadWithoutSleep implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }

    @Override
    public void run() {
        int num = 0;
        int k = 0;
        while ((!Thread.currentThread().isInterrupted()) && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println("符合数:" + num);
                k++;
            }
            num++;
        }
        System.out.println("结束" + k);
    }
}

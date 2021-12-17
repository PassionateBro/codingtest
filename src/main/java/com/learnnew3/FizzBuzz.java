package com.learnnew3;

import java.util.function.IntConsumer;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-12-17 16:07
 */
public class FizzBuzz {
    private int n;
    private int x = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (x <= n) {
                if (x % 3 == 0 && x % 5 != 0) {
                    printFizz.run();
                    x++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (x <= n) {
                if (x % 5 == 0 && x % 3 != 0) {
                    printBuzz.run();
                    x++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (x <= n) {
                if (x % 3 == 0 && x % 5 == 0) {
                    printFizzBuzz.run();
                    x++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (x <= n) {
                if (x % 3 != 0 && x % 5 != 0) {
                    printNumber.accept(x);
                    x++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }
}


package com.learnnew5;

/**
 * @describtion: 2043. 简易银行系统
 * @author: CaiJm
 * @Date: 2022-03-18 9:28
 */
public class Bank {
    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > 0 && account1 <= balance.length && account2 > 0 && account2 <= balance.length && balance[account1 - 1] >= money) {
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account > 0 && account <= balance.length) {
            balance[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (account > 0 && account <= balance.length && balance[account - 1] >= money) {
            balance[account - 1] -= money;
            return true;
        }
        return false;
    }
}

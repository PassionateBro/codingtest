package com.learnnew3;

/**
 * @describtion: 292. Nim 游戏
 * @author: CaiJm
 * @Date: 2022-01-21 14:46
 */
public class CanWinNim {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) return false;
        return true;
    }
}

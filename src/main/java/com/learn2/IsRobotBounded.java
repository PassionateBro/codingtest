package com.learn2;

/**
 * @describtion: 1041. 困于环中的机器人
 * @author: CaiJm
 * @Date: 2021-11-11 9:36
 */
public class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, currDir = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                char ch = instructions.charAt(j);
                if (ch == 'G') {
                    x = currDir == 1 ? x + 1 : (currDir == 3 ? x - 1 : x);
                    y = currDir == 0 ? y + 1 : (currDir == 2 ? y - 1 : y);
                }
                else if (ch == 'R')
                    currDir = currDir == 3 ? 0 : currDir + 1;
                else
                    currDir = currDir == 0 ? 3 : currDir - 1;
            }
            if (x == 0 && y == 0)
                return true;
        }
        return false;
    }
}

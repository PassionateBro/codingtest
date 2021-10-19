package com.learn;

/**
 * @describtion: 796. 旋转字符串
 * @author: CaiJm
 * @Date: 2021-10-15 11:12
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}

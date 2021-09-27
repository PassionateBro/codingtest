package com.learn;

/**
 * @describtion: 1784. 检查二进制字符串字段
 * @author: CaiJm
 * @Date: 2021-09-01 10:05
 */
public class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}

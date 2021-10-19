package com.learn;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-10-14 10:44
 */
public class NumberOfRounds {
    public static int numberOfRounds(String startTime, String finishTime) {
        String[] start = startTime.split(":");
        String[] end = finishTime.split(":");
        int startH = Integer.valueOf(start[0]);
        int startM = Integer.valueOf(start[1]);
        int endH = Integer.valueOf(end[0]);
        int endM = Integer.valueOf(end[1]);
        int entire = 0;
        if (startH > endH) {
            entire = 24 - startH - 1 + endH;
        } else {
            if (startH == endH && startM > endM) {
                entire = 24 - startH - 1 + endH;
            } else {
                entire = endH - startH - 1;
            }
        }
        int res = 4 * entire + ((60 - startM) / 15) + (endM / 15);
        return res < 0 ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfRounds("00:47", "00:57"));
    }

}

package com.test;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-04-17 10:12
 */
public class TidTest {
    public static void main(String[] args) {

        long hour = 0;
        long index = 0;

        long HOUR =3600 * 1000L;
        long ts = System.currentTimeMillis();

        hour = ts / HOUR;
        long savedHour = ts / HOUR;
        long indexInHour = (ts % HOUR) * 100;
        if (hour != savedHour) {
            savedHour = hour;
            indexInHour = 0;
        }

        indexInHour++;
        index = indexInHour;

    }
}

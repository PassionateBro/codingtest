package com.ocrtest;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-06-29 11:09
 */
public class CodeTest {
    public static void main(String[] args) {
        String gender = "性别男民族汉";
        String fm = gender.substring(gender.indexOf("性别") + 2, gender.indexOf("性别") + 3);
        String nation = gender.substring(gender.indexOf("民族") + 2);
        System.out.println(fm.equals("男") ? 1 : 2);
        System.out.println(nation);
    }
}

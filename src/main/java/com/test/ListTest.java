package com.test;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-07-20 13:40
 */
public class ListTest {

    {
        System.out.println("11111111111111111111111");
    }

    static {
        System.out.println("22222222222222222222222222");
    }

    public ListTest() {
        setId((int) (Math.random() * 100));
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }

    private Integer id;


    public static void main(String[] args) {
//        List<ListTest> listTests = Arrays.asList(new ListTest(), new ListTest());
//        Collections.sort(listTests, new Comparator<ListTest>() {
//            @Override
//            public int compare(ListTest o1, ListTest o2) {
//                return o1.getId().compareTo(o2.getId());
//            }
//        });
//        System.out.println(listTests);
        System.out.println("333333333333333333333");
        ListTest listTest = new ListTest();
    }
}

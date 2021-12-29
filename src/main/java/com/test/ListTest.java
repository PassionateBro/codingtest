package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-07-20 13:40
 */
public class ListTest {

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


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        HashSet<String> set = new HashSet<>();
        set.add("1234");
    }
}

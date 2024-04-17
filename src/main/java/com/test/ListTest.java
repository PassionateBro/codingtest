package com.test;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

}

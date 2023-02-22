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


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InterruptedException {
//        HashSet<Integer> driverIds = new HashSet<>();
//        driverIds.add(1);
//        driverIds.add(2);
//        int mergeFileDriverCount = driverIds.size();
//        deal(driverIds);
//        int b = driverIds.size();
//        System.out.println(mergeFileDriverCount);
//        System.out.println(b);
        NewSource newSource = new NewSource();
        ArrayList<NewSource> list = new ArrayList<>();
        list.add(newSource);
        System.out.println(list.get(0).hashCode());
        List<NewSource> integers = list.subList(0, 1);
        System.out.println(integers.get(0).hashCode());
    }

    public static void deal(Set<Integer> driverIds) {
        driverIds = driverIds.stream().filter(c-> c != 1).collect(Collectors.toSet());
        System.out.println(driverIds);
    }
}

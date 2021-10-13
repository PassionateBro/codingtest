package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        ListTest listTest = new ListTest(); // instance
        listTest.setId(4);
        Class<? extends ListTest> aClass = listTest.getClass();
        StringBuilder xml = new StringBuilder();
        String xmlReal = "<id>***id***</id>";  // 转换对象
        System.out.println(xmlReal);
        char[] chars = xmlReal.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; ) {
            if (chars[i] != '*') {
                xml.append(chars[i]);
                i++;
                continue;
            }
            StringBuilder words = new StringBuilder();
            for (int j = i + 3; j < len; j++) {
                if (chars[j] != '*') {
                    words.append(chars[j]);
                } else {
                    break;
                }
            }
            Method method = aClass.getMethod("get" + words.substring(0, 1).toUpperCase() + words.substring(1, words.length()));
            String res = String.valueOf(method.invoke(listTest));
            xml.append(res);
            i = i + 6 + words.length();
        }
        System.out.println(xml);
    }
}

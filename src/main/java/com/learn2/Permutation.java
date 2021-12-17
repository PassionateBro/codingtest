package com.learn2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @describtion: 面试题 08.07. 无重复字符串的排列组合
 * @author: CaiJm
 * @Date: 2021-12-16 15:28
 */
public class Permutation {
    private static List<String> res = new ArrayList();

    public static String[] permutation(String S) {
        char[] chars = S.toCharArray();
        int idx = chars.length;
        ArrayList<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            idxList.add(i);
        }
        dfs(new char[idx], chars, 0, idxList);
        String[] strings = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            strings[i] = res.get(i);
        }
        return strings;
    }

    private static void dfs(char[] com, char[] chars, int nowIdx, ArrayList<Integer> idxList) {
        if (nowIdx == chars.length) {
            res.add(new String(com));
            return;
        }
        for (Integer i : idxList) {
            com[nowIdx] = chars[i];
            char[] chars1 = Arrays.copyOf(com, chars.length);
            ArrayList<Integer> objects = new ArrayList<>(idxList.size());
            objects.addAll(idxList);
            objects.remove(i);
            dfs(chars1, chars, nowIdx + 1, objects);
        }
    }

    public static void main(String[] args) {
        permutation("qwe");
    }
}

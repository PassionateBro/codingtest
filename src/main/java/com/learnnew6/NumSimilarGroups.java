package com.learnnew6;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-06-23 16:42
 */
public class NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        int size = 0;
        int[] groups = new int[strs.length];
        int[] rank = new int[strs.length];
        for (int i = 0; i < groups.length; i++) {
            rank[i] = 1;
            groups[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (judgeSimilar(strs[i], strs[j])) {
                    int findX = find(i, groups), findY = find(j, groups);
                    if (findX == findY) {
                        continue;
                    }
                    size++;
                    if (rank[findX] <= rank[findY]) {
                        groups[findX] = findY;
                    } else {
                        groups[findY] = findX;
                    }
                    if (rank[findX] == rank[findY]) {
                        rank[findY]++;
                    }
                }
            }
        }
        return strs.length - size;
    }

    public int find(int x, int[] groups) {
        if (groups[x] == x) return x;
        return groups[x] = find(groups[x], groups);
    }

    public boolean judgeSimilar(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int times = 0;
        char x1 = 'a', y1 = 'b', x2 = 'c', y2 = 'd';
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != cb[i]) {
                if (times == 2) {
                    return false;
                }
                if (times == 0) {
                    x1 = ca[i];
                    y1 = cb[i];
                }
                if (times == 1) {
                    x2 = ca[i];
                    y2 = cb[i];
                }
                times++;
            }
        }
        if (times == 2) {
            return x1 == y2 && y1 == x2;
        }
        return times == 0;
    }
}

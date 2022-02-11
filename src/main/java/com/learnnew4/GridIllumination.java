package com.learnnew4;

import java.util.HashMap;

/**
 * @describtion: 1001. 网格照明
 * @author: CaiJm
 * @Date: 2022-02-08 9:14
 */
public class GridIllumination {
    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] res = new int[queries.length];
        HashMap<String, Integer> dp = new HashMap<>();
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> columnMap = new HashMap<>();
        HashMap<Integer, Integer> poMap = new HashMap<>();
        HashMap<Integer, Integer> neMap = new HashMap<>();
        // 以(0,0) 为坐标原点，记录偏移量
        for (int i = 0; i < lamps.length; i++) {
            String key = lamps[i][0] + "," + lamps[i][1];
            dp.put(key, dp.getOrDefault(key, 0) + 1);
            rowMap.put(lamps[i][0], rowMap.getOrDefault(lamps[i][0], 0) + 1);
            columnMap.put(lamps[i][1], columnMap.getOrDefault(lamps[i][1], 0) + 1);
            int b = lamps[i][1] - lamps[i][0];
            neMap.put(b, neMap.getOrDefault(b, 0) + 1);
            int a = -lamps[i][1] - lamps[i][0];
            poMap.put(a, poMap.getOrDefault(a, 0) + 1);
        }
        int idx = 0;
        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0];
            int column = queries[i][1];
            Integer rowNum = rowMap.get(row);
            Integer columnNum = columnMap.get(column);
            if (rowNum != null && rowNum > 0) {
                res[idx] = 1;
            } else if (columnNum != null && columnNum > 0) {
                res[idx] = 1;
            } else {
                // 找对角线
                int a = -row - column;
                if (poMap.get(a) != null && poMap.get(a) > 0) {
                    res[idx] = 1;
                } else {
                    a = -row + column;
                    if (neMap.get(a) != null && neMap.get(a) > 0) {
                        res[idx] = 1;
                    }
                }
            }
            idx++;
            // 执行灭灯操作
            for (int j = row - 1; j <= row + 1 && j < n; j++) {
                if (j < 0) continue;
                for (int k = column - 1; k <= column + 1 && k < n; k++) {
                    if (k < 0) continue;
                    String key = j + "," + k;
                    int value = dp.getOrDefault(key,0);
                    if (value > 0) {
                        rowMap.put(j, rowMap.get(j) - value);
                        columnMap.put(k, columnMap.get(k) - value);
                        int b = k - j;
                        neMap.put(b, neMap.get(b) - value);
                        int a = -k - j;
                        poMap.put(a, poMap.get(a) - value);
                        dp.put(key, 0);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 0},{0,1},{0,4}};
        int[][] b = new int[][]{{0, 0}, {0, 1},{0,2}};
        gridIllumination(6, a, b);
    }
}

package com.lerannew7;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-11 10:22
 */
public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        StringBuilder res = new StringBuilder();
        for (String temp : s) {
            if (temp.length() <= 2) {
                res.append(temp.toLowerCase()).append(" ");
            } else {
                String had = temp.substring(0, 1);
                res.append(had.toUpperCase()).append(temp.substring(1).toLowerCase()).append(" ");
            }
        }
        return res.substring(0, res.length() - 1);
    }
}

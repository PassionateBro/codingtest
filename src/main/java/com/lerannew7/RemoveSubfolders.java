package com.lerannew7;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-02-08 9:44
 */
public class RemoveSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < folder.length; i++) {
            char[] chars = folder[i].toCharArray();
            StringBuilder tempS = new StringBuilder();
            tempS.append(chars[0]);
            boolean deal = true;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == '/') {
                    if (set.contains(tempS.toString())) {
                        deal = false;
                        break;
                    }
                }
                tempS.append(chars[j]);
            }
            if (deal) set.add(tempS.toString());
        }
        return new ArrayList<>(set);
    }
}

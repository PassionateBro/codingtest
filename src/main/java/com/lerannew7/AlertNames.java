package com.lerannew7;

import java.util.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-02-07 9:40
 */
public class AlertNames {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> resList = new ArrayList<>();
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0, len = keyName.length; i < len; i++) {
            if (!map.containsKey(keyName[i])) {
                map.put(keyName[i], new PriorityQueue<Integer>());
            }
            String[] time = keyTime[i].split(":");
            map.get(keyName[i]).add(Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]) );
        }
        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> pq = entry.getValue();
            while (pq.size() > 2) {
                int t1 = pq.poll();
                int t2 = pq.peek();
                if (t2 - t1 <= 60) {
                    t2 = pq.poll();
                    int t3 = pq.peek();
                    if (t3 - t1 <= 60) {
                        resList.add(entry.getKey());
                        break;
                    }
                    pq.offer(t2);
                }
            }
        }
        Collections.sort(resList);
        return resList;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"john","john","john"};
        String[] b = new String[]{"23:58","23:59","00:01"};
        alertNames(a,b);
    }
}

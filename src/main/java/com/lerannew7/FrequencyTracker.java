package com.lerannew7;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-21 9:54
 */
public class FrequencyTracker {
    HashMap<Integer, HashSet<Integer>> nums;
    HashMap<Integer, Integer> times;

    public FrequencyTracker() {
        nums = new HashMap<>();
        times = new HashMap<>();
    }

    public void add(int number) {
        Integer integer = times.get(number);
        if (integer != null) {
            times.put(number, integer + 1);
            nums.get(integer).remove(number);
            HashSet<Integer> integers = nums.get(integer + 1);
            if (integers == null) {
                HashSet<Integer> set = new HashSet<>();
                set.add(number);
                nums.put(integer + 1, set);
            } else {
                integers.add(number);
            }
        } else {
            times.put(number, 1);
            HashSet<Integer> integers = nums.get(1);
            if (integers == null) {
                HashSet<Integer> set = new HashSet<>();
                set.add(number);
                nums.put(1, set);
            } else {
                integers.add(number);
            }
        }
    }

    public void deleteOne(int number) {
        Integer integer = times.get(number);
        if (integer != null) {
            if (integer.equals(1)) {
                times.remove(number);
                nums.get(integer).remove(number);
            } else {
                times.put(number, integer - 1);
                nums.get(integer).remove(number);
                HashSet<Integer> set = nums.getOrDefault(integer - 1, new HashSet<>());
                set.add(number);
                nums.put(integer - 1, set);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        HashSet<Integer> integers = nums.get(frequency);
        if (integers != null && integers.size() > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FrequencyTracker s = new FrequencyTracker();
        s.add(1);
        s.add(3);
        s.add(3);
        System.out.println(s.hasFrequency(2));
    }
}

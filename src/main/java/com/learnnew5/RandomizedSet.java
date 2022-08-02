package com.learnnew5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-04-13 11:08
 */
public class RandomizedSet {
    HashSet<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int x = 0;
        int n = new Random().nextInt(set.size());
        Iterator<Integer> iterator = set.iterator();
        int res = 0;
        while (iterator.hasNext() && x <= n) {
            res = iterator.next();
            x++;
        }
        return res;
    }
}

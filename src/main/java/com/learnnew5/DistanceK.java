package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-03-16 14:50
 */
public class DistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> objects = new ArrayList<>();
        deal(root, target, k, 0, false, objects);
        return objects;
    }

    private int deal(TreeNode root, TreeNode target, int k, int step, boolean find, List<Integer> res) {
        if (root == null) return 0;
        if (root.val == target.val) {
            if (k == 0) {
                res.add(root.val);
            }
            deal(root.left, target, k, 1, true, res);
            deal(root.right, target, k, 1, true, res);
            return step;
        }
        if (find) {
            if (k == step) {
                res.add(root.val);
                return 0;
            } else {
                deal(root.left, target, k, step + 1, true, res);
                deal(root.right, target, k, step + 1, true, res);
            }
        } else {
            int left = deal(root.left, target, k, step + 1, false, res);
            int right = deal(root.right, target, k, step + 1, false, res);
            if (left > 0) {
                if (left - step == k) {
                    res.add(root.val);
                } else {
                    deal(root.right, target, k, left - step + 1, true, res);
                }
                return left;
            }
            if (right > 0) {
                if (right - step == k) {
                    res.add(root.val);
                } else {
                    deal(root.left, target, k, right - step + 1, true, res);
                }
                return right;
            }
        }
        return 0;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

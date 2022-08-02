package com.learnnew6;

import com.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-06-24 9:40
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> left = new LinkedList<>();
        Deque<TreeNode> right = new LinkedList<>();
        left.add(root);
        while (!left.isEmpty() || !right.isEmpty()) {
            int maxValue = Integer.MIN_VALUE;
            if (left.isEmpty()) {
                while (!right.isEmpty()) {
                    TreeNode treeNode = right.pollFirst();
                    maxValue = Math.max(treeNode.val, maxValue);
                    if (treeNode.left != null) {
                        left.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        left.addLast(treeNode.right);
                    }
                }
            } else {
                while (!left.isEmpty()) {
                    TreeNode treeNode = left.pollFirst();
                    maxValue = Math.max(treeNode.val, maxValue);
                    if (treeNode.left != null) {
                        right.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        right.addLast(treeNode.right);
                    }
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}

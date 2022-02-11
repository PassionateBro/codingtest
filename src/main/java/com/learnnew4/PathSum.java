package com.learnnew4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @author: CaiJm
 * @Date: 2022-02-11 9:47
 */
public class PathSum {
    int target;
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        this.target = target;
        dfs(root, 0, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        list.add(root.val);
        if (sum == target) {
            if (root.left == null && root.right == null) {
                LinkedList<Integer> resList = new LinkedList<>(list);
                res.add(resList);
                list.pollLast();
                return;
            }
        }
        dfs(root.left, sum, list);
        dfs(root.right, sum, list);
        list.pollLast();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

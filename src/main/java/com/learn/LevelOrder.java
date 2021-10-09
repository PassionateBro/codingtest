package com.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @author: CaiJm
 * @Date: 2021-10-09 16:21
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<Integer> objects = new LinkedList<>();
        LinkedList<TreeNode> roots = new LinkedList<>();
        roots.add(root);
        add(roots, objects);
        int[] ints = new int[objects.size()];
        int i = 0;
        for (Integer val : objects) {
            ints[i] = val;
            i++;
        }
        return ints;
    }

    private void add(List<TreeNode> nodeList, LinkedList<Integer> list) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        for (TreeNode node : nodeList) {
            list.add(node.val);
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }
        if (nodes.size() > 0) add(nodes, list);
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

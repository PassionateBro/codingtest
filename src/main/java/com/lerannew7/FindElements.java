package com.lerannew7;

import java.util.HashSet;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-03-12 9:42
 */
public class FindElements {

    private TreeNode treeNode;
    private HashSet<Integer> set;

    public FindElements(TreeNode root) {
        root.val = 0;
        set = new HashSet<>();
        set.add(0);
        dealTree(root);
        treeNode = root;
    }

    private void dealTree(TreeNode node) {
        set.add(node.val);
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            dealTree(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            dealTree(node.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
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

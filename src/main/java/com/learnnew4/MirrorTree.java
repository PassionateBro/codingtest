package com.learnnew4;

/**
 * @describtion: 剑指 Offer 27. 二叉树的镜像
 * @author: CaiJm
 * @Date: 2022-02-09 10:27
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }

    private void mirror(TreeNode node) {
        if (node == null) return;
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        mirror(node.left);
        mirror(node.right);
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

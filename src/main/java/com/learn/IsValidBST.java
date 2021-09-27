package com.learn;


/**
 * @describtion: 98. 验证二叉搜索树
 * @author: CaiJm
 * @Date: 2021-09-17 10:17
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        int val = root.val;
        TreeNode left = root.left;
        if (root.left != null) {
            if (root.left.val >= val) return false;
        }
        if (root.right != null) {
            if (root.right.val <= val) return false;
        }
        return valid(left, Long.valueOf(Integer.MIN_VALUE) - 1, val) && valid(root.right, val, Long.valueOf(Integer.MAX_VALUE) + 1);
    }

    private boolean valid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (!(node.val > min && node.val < max)) {
            return false;
        }
        if (node.left != null) {
            if (node.left.val >= node.val || node.left.val <= min) return false;
        }
        if (node.right != null) {
            if (node.right.val <= node.val || node.right.val >= max) return false;
        }
        return valid(node.left, min, Math.min(max, node.val)) && valid(node.right, Math.max(min, node.val), max);
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

    public static void main(String[] args) {
        System.out.println(Long.valueOf(Integer.MIN_VALUE) - 1);
    }
}

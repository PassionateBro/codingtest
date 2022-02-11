package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-09 10:11
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val) {
            if (judge(root, subRoot)) return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean judge(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            return judge(root.left, subRoot.left) && judge(root.right, subRoot.right);
        } else {
            return false;
        }
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

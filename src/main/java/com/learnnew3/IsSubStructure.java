package com.learnnew3;

import com.TreeNode;

/**
 * @describtion: 剑指 Offer 26. 树的子结构
 * @author: CaiJm
 * @Date: 2021-12-31 11:11
 */
public class IsSubStructure {
    boolean res = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        return findSubTree(A, B.val, B);
    }

    private boolean findSubTree(TreeNode root, int val, TreeNode B) {
        if (root == null) return false;
        if (root.val == val) {
            boolean judge = judge(root, B);
            if (judge) return true;
        }
        boolean subTree = findSubTree(root.left, val, B);
        if (subTree) {
            return true;
        } else {
            return findSubTree(root.right, val, B);
        }
    }

    private boolean judge(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null && B != null) return false;
        if (A.val != B.val) return false;
        return judge(A.left, B.left) && judge(A.right, B.right);
    }
}

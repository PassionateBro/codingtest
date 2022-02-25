package com.learnnew5;

/**
 * @describtion: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @author: CaiJm
 * @Date: 2022-02-14 14:04
 */
public class LowestCommonAncestor {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return res;
    }

    private boolean dfs(TreeNode root, int p, int q) {
        if (root == null) return false;
        if (root.val == p || root.val == q) {
            if (dfs(root.left, p, q) || dfs(root.right, p, q)) {
                if (res == null) {
                    res = root;
                }
            }
            return true;
        }
        boolean l = dfs(root.right, p, q);
        boolean r = dfs(root.left, p, q);
        if (l && r && res == null) {
            res = root;
            return true;
        }
        return l || r;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package com.learnnew4;

/**
 * @describtion: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @author: CaiJm
 * @Date: 2022-02-11 10:17
 */
public class KthLargest {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
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

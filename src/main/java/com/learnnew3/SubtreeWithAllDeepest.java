package com.learnnew3;

import com.TreeNode;

/**
 * @describtion: 865. 具有所有最深节点的最小子树
 * @author: CaiJm
 * @Date: 2021-12-17 10:56
 */
public class SubtreeWithAllDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        int h1 = heigth(root.left);
        int h2 = heigth(root.right);
        if (h1 == h2) return root;
        if (h1 > h2) return subtreeWithAllDeepest(root.left);
        return subtreeWithAllDeepest(root.right);
    }

    int heigth(TreeNode root) {
        return root == null ? 0 : Math.max(heigth(root.left), heigth(root.right)) + 1;
    }

}

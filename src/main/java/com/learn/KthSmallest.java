package com.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 230. 二叉搜索树中第K小的元素
 * @author: CaiJm
 * @Date: 2021-10-18 9:38
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> integers = new LinkedList<>();
        dfs(root, integers, k);
        return integers.get(k - 1);
    }

    void dfs(TreeNode root, List list, int k) {
        if (list.size() == k) return;
        if (root.left != null) {
            dfs(root.left, list, k);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list, k);
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

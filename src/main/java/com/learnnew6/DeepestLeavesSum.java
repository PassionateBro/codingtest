package com.learnnew6;

import com.TreeNode;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-18 13:41
 */
public class DeepestLeavesSum {
    private int nowHeight = 0;
    private int val = 0;

    public int deepestLeavesSum(TreeNode root) {
        deep(root, val);
        return val;
    }

    private void deep(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            if (height > nowHeight) {
                nowHeight = height;
                val = root.val;
            } else if (height == nowHeight) {
                val += root.val;
            } else {
                return;
            }
        }
        if (root.left != null) {
            deep(root.left, height + 1);
        }
        if (root.right != null) {
            deep(root.right, height + 1);
        }
    }
}

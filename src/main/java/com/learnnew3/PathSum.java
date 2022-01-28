package com.learnnew3;

import com.TreeNode;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-12-31 9:36
 */
public class PathSum {
    int sum = 0;
    int target = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        target = targetSum;
        find(root, root.val);
        if (root.right != null || root.left != null) {
            if (root.val == target) {
                sum++;
            }
        }
        return sum;
    }

    private void find(TreeNode root, int nowVal) {
        if (root.right != null) {
            if (root.right.val == target) sum++;
            int i = root.right.val + nowVal;
            find(root.right, i - root.val);
            find(root.right, i);
            if (i == target) sum++;
        }
        if (root.left != null) {
            if (root.left.val == target) sum++;
            int i = root.left.val + nowVal;
            find(root.left, i - root.val);
            find(root.left, i);
            if (i == target) sum++;
        }
    }
}

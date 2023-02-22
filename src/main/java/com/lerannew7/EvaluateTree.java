package com.lerannew7;

import com.TreeNode;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-02-07 14:01
 */
public class EvaluateTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        return root.val == 2 ? (evaluateTree(root.left) || evaluateTree(root.right)) : (evaluateTree(root.left) && evaluateTree(root.right));
    }

    public static void main(String[] args) {
    }
}

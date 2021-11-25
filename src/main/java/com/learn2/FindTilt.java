package com.learn2;

/**
 * @describtion: 563. 二叉树的坡度
 * @author: CaiJm
 * @Date: 2021-11-18 9:12
 */
public class FindTilt {
    private int result;

    public int findTilt(TreeNode root) {
        return result;
    }

    public int res(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = res(node.left);
        int right = res(node.right);
        this.result += Math.abs(left - right);
        return left + right + node.val;
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

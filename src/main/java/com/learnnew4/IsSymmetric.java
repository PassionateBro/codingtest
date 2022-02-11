package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-09 10:30
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        StringBuilder s = new StringBuilder();
        addList(root, s);
        mirror(root);
        StringBuilder newS = new StringBuilder();
        addList(root, newS);
        return s.toString().equals(newS.toString());
    }

    private void addList(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("#");
            return;
        }
        s.append(root.val).append(",");
        addList(root.left, s);
        addList(root.right, s);
    }
    private void mirror(TreeNode node) {
        if (node == null) return;
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        mirror(node.left);
        mirror(node.right);
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

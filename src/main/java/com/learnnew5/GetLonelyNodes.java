package com.learnnew5;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion: 1469. 寻找所有的独生节点
 * @author: CaiJm
 * @Date: 2022-03-15 14:13
 */
public class GetLonelyNodes {
    List<Integer> list = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null) return list;
        if (root.left == null && root.right != null) {
            list.add(root.right.val);
            return getLonelyNodes(root.right);
        }
        if (root.left != null && root.right == null) {
            list.add(root.left.val);
            return getLonelyNodes(root.left);
        }
        if (root.left != null && root.right != null) {
            getLonelyNodes(root.left);
            getLonelyNodes(root.right);
        }
        return list;
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

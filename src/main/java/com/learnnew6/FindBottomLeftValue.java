package com.learnnew6;

import com.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion: 513. 找树左下角的值
 * @author: CaiJm
 * @Date: 2022-06-22 11:16
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        Deque<TreeNode> tempQueue = new LinkedList<>();
        boolean conti = true;
        while (!deque.isEmpty() && conti) {
            conti = false;
            TreeNode first = null;
            while (!deque.isEmpty()) {
                TreeNode treeNode = deque.pollFirst();
                if (first == null) {
                    first = treeNode;
                }
                if (treeNode.left != null || treeNode.right != null) {
                    conti = true;
                }
                if (treeNode.left != null) {
                    tempQueue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempQueue.addLast(treeNode.right);
                }
            }
            if (!conti) {
                return first.val;
            }
            deque = tempQueue;
            tempQueue = new LinkedList<>();
        }
        return root.val;
    }
}

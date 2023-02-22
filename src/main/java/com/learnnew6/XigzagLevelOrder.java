package com.learnnew6;

import com.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-09-19 14:18
 */
public class XigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> lQueue = new LinkedList<>();
        Deque<TreeNode> rQueue = new LinkedList<>();
        lQueue.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!lQueue.isEmpty() || !rQueue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (!lQueue.isEmpty() && rQueue.isEmpty()) {
                while (!lQueue.isEmpty()) {
                    TreeNode treeNode = lQueue.pollFirst();
                    temp.add(treeNode.val);
                    if (treeNode.left != null) {
                        rQueue.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        rQueue.addLast(treeNode.right);
                    }
                }
            } else if (lQueue.isEmpty() && !rQueue.isEmpty()) {
                while (!rQueue.isEmpty()) {
                    TreeNode treeNode = rQueue.pollLast();
                    temp.add(treeNode.val);
                    if (treeNode.right != null) {
                        lQueue.addFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        lQueue.addFirst(treeNode.left);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }


    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = s1+s2;
        String s4 = "ab";
        String s5 = "ab";
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
    }
}

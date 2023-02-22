package com.learnnew6;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-08-05 14:18
 */
public class Solution2 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Deque<TreeNode> ad = new ArrayDeque<>();
        ad.offer(root);
        int cur = 1;
        while (!ad.isEmpty()) {
            cur++;
            int size = ad.size();
            if (cur == depth) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = ad.poll(), left = node.left, right = node.right;
                    node.left = new TreeNode(val);
                    node.left.left = left;
                    node.right = new TreeNode(val);
                    node.right.right = right;
                }
                return root;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = ad.poll();
                    if (node.left != null) ad.offer(node.left);
                    if (node.right != null) ad.offer(node.right);
                }
            }
        }
        return root;
    }

    public String reformat(String s) {
        Stack<Character> a = new Stack<Character>();
        Stack<Character> b = new Stack<Character>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                a.push(c[i]);
            } else {
                b.push(c[i]);
            }
        }
        if (Math.abs(a.size() - b.size()) > 1) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        if (a.size() > b.size()) {
            res.append(a.pop());
            while (!a.isEmpty()) {
                res.append(b.pop());
                res.append(a.pop());
            }
        } else if (a.size() == b.size()) {
            while (!a.isEmpty()) {
                res.append(b.pop());
                res.append(a.pop());
            }
        } else {
            res.append(b.pop());
            while (!b.isEmpty()) {
                res.append(a.pop());
                res.append(b.pop());
            }
        }
        return res.toString();

    }
}

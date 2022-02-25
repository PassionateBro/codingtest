package com.learnnew5;

import com.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @describtion: 剑指 Offer 37. 序列化二叉树
 * @author: CaiJm
 * @Date: 2022-02-22 11:01
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return stringBuilder.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        return deserialize(nodes, atomicInteger);
    }

    private void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("# ");
            return;
        }
        stringBuilder.append(root.val + " ");
        dfs(root.left, stringBuilder);
        dfs(root.right, stringBuilder);
    }

    private TreeNode deserialize(String[] nodes, AtomicInteger idx) {
        idx.incrementAndGet();
        if (idx.intValue() >= nodes.length) return null;
        String node = nodes[idx.intValue()];
        if (node.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(node));
        treeNode.left = deserialize(nodes, idx);
        treeNode.right = deserialize(nodes, idx);
        return treeNode;
    }
}
